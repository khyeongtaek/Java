import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Main extends JFrame {
    /**
     * 테트리스 게임 방법:
     * - 왼쪽 방향키: 블록을 왼쪽으로 이동
     * - 오른쪽 방향키: 블록을 오른쪽으로 이동
     * - 아래쪽 방향키: 블록을 빠르게 아래로 이동
     * - 위쪽 방향키: 블록을 회전
     * - 한 줄이 가득 차면 해당 줄이 제거됩니다
     * - 블록이 천장에 닿으면 게임이 종료됩니다
     */
    private static final int BOARD_WIDTH = 15;
    private static final int BOARD_HEIGHT = 25;
    private static final int BLOCK_SIZE = 30;

    public Main() {
        setTitle("Tetris Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel gamePanel = new GamePanel();
        add(gamePanel);

        pack();

        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Main game = new Main();
            game.setVisible(true);
        });
    }

    private class GamePanel extends JPanel {
        private boolean[][] board;
        private Shape currentShape;
        private Shape nextShape;
        private Timer timer;
        private boolean isGameOver;
        private int score;

        public GamePanel() {
            setPreferredSize(new Dimension(BOARD_WIDTH * BLOCK_SIZE + 200, BOARD_HEIGHT * BLOCK_SIZE));
            setBackground(Color.DARK_GRAY);
            setFocusable(true);
            board = new boolean[BOARD_HEIGHT][BOARD_WIDTH];
            score = 0;
            nextShape = new Shape();
            currentShape = new Shape();
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (!isGameOver) {
                        switch (e.getKeyCode()) {
                            case KeyEvent.VK_LEFT -> currentShape.moveLeft();
                            case KeyEvent.VK_RIGHT -> currentShape.moveRight();
                            case KeyEvent.VK_DOWN -> currentShape.moveDown();
                            case KeyEvent.VK_UP -> currentShape.rotate();
                            case KeyEvent.VK_SPACE -> currentShape.dropToBottom();
                        }
                        repaint();
                    } else if (e.getKeyCode() == KeyEvent.VK_R) {
                        resetGame();
                    }
                }
            });

            timer = new Timer(1200, e -> {
                if (!isGameOver) {
                    gameStep();
                }
            });
            timer.start();
        }

        private void gameStep() {
            if (!currentShape.moveDown()) {
                addToBoard();
                clearLines();
                currentShape = nextShape;
                nextShape = new Shape();
                if (!currentShape.isValidMove()) {
                    isGameOver = true;
                    timer.stop();
                }
            }
            repaint();
        }

        private void addToBoard() {
            Point[] blocks = currentShape.getBlocks();
            for (Point block : blocks) {
                if (block.y >= 0) {
                    board[block.y][block.x] = true;
                }
            }
        }

        private void clearLines() {
            int linesCleared = 0;
            for (int row = BOARD_HEIGHT - 1; row >= 0; row--) {
                boolean isLineFull = true;
                for (int col = 0; col < BOARD_WIDTH; col++) {
                    if (!board[row][col]) {
                        isLineFull = false;
                        break;
                    }
                }
                if (isLineFull) {
                    for (int r = row; r > 0; r--) {
                        System.arraycopy(board[r - 1], 0, board[r], 0, BOARD_WIDTH);
                    }
                    row++;
                    linesCleared++;
                }
            }
            score += linesCleared * 100;
        }

        private void resetGame() {
            board = new boolean[BOARD_HEIGHT][BOARD_WIDTH];
            score = 0;
            isGameOver = false;
            nextShape = new Shape();
            currentShape = new Shape();
            timer.start();
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw board
            for (int row = 0; row < BOARD_HEIGHT; row++) {
                for (int col = 0; col < BOARD_WIDTH; col++) {
                    if (board[row][col]) {
                        drawBlock(g, col, row, Color.GRAY);
                    }
                }
            }

            // Draw current shape and ghost
            if (!isGameOver) {
                currentShape.drawGhost(g);
                currentShape.draw(g);
            }

            // Draw next shape preview
            g.setColor(Color.BLACK);
            g.fillRect(BOARD_WIDTH * BLOCK_SIZE, 0, 200, BOARD_HEIGHT * BLOCK_SIZE);
            g.setColor(Color.WHITE);
            g.drawRect(BOARD_WIDTH * BLOCK_SIZE, 0, 200, BOARD_HEIGHT * BLOCK_SIZE);
            g.drawString("Next Shape:", BOARD_WIDTH * BLOCK_SIZE + 10, 30);

            // Save the current transform
            Graphics2D g2d = (Graphics2D) g.create();
            // Translate to preview area and adjust for piece center
            g2d.translate(BOARD_WIDTH * BLOCK_SIZE + 50, 50);
            // Draw shape with adjusted coordinates
            for (Point block : nextShape.getBlocks()) {
                drawBlock(g2d, block.x -5, block.y, nextShape.color);
            }
            g2d.dispose();

            // Draw score
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Score: " + score, BOARD_WIDTH * BLOCK_SIZE + 20, 150);

            // Draw game over message
            if (isGameOver) {
                String msg = "Game Over";
                String restart = "Press 'R' to Restart";
                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.BOLD, 20));
                FontMetrics fm = g.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(msg)) / 2;
                int y = getHeight() / 2;
                g.drawString(msg, x, y);
                g.drawString(restart, x - 20, y + 30);
            }
        }

        private void drawBlock(Graphics g, int x, int y, Color color) {
            g.setColor(color);
            g.fillRect(x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
            g.setColor(Color.BLACK);
            g.drawRect(x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
        }

        private class Shape {
            private Point[] blocks;
            private Color color;

            public Shape() {
                blocks = new Point[4];
                Random random = new Random();
                int type = random.nextInt(13); // Increased range for weighted probability
                this.color = new Color(random.nextInt(128, 255), random.nextInt(128, 255), random.nextInt(128, 255));

                switch (type) {
                    case 6, 7, 8 -> { // I - increased probability (60%)
                        blocks[0] = new Point(7, -3);
                        blocks[1] = new Point(7, -2);
                        blocks[2] = new Point(7, -1);
                        blocks[3] = new Point(7, 0);
                    }
                    case 9 -> { // O
                        blocks[0] = new Point(7, 0);
                        blocks[1] = new Point(8, 0);
                        blocks[2] = new Point(7, 1);
                        blocks[3] = new Point(8, 1);
                    }
                    case 10 -> { // T
                        blocks[0] = new Point(7, 0);
                        blocks[1] = new Point(6, 1);
                        blocks[2] = new Point(7, 1);
                        blocks[3] = new Point(8, 1);
                    }
                    case 11 -> { // S 
                        blocks[0] = new Point(7, 0);
                        blocks[1] = new Point(8, 0);
                        blocks[2] = new Point(6, 1);
                        blocks[3] = new Point(7, 1);
                    }
                    case 12 -> { // Z
                        blocks[0] = new Point(6, 0);
                        blocks[1] = new Point(7, 0);
                        blocks[2] = new Point(7, 1);
                        blocks[3] = new Point(8, 1);
                    }
                    default -> { // J
                        blocks[0] = new Point(6, 0);
                        blocks[1] = new Point(6, 1);
                        blocks[2] = new Point(7, 1);
                        blocks[3] = new Point(8, 1);
                    }
                    }
                }
            }

            public void draw(Graphics g) {
                for (Point block : blocks) {
                    drawBlock(g, block.x, block.y, color);
                }
            }

            public boolean moveDown() {
                for (Point block : blocks) {
                    block.y++;
                }
                if (!isValidMove()) {
                    for (Point block : blocks) {
                        block.y--;
                    }
                    return false;
                }
                return true;
            }

            public void moveLeft() {
                for (Point block : blocks) {
                    block.x--;
                }
                if (!isValidMove()) {
                    for (Point block : blocks) {
                        block.x++;
                    }
                }
            }

            public void moveRight() {
                for (Point block : blocks) {
                    block.x++;
                }
                if (!isValidMove()) {
                    for (Point block : blocks) {
                        block.x--;
                    }
                }
            }

            public void rotate() {
                Point center = blocks[1];
                // 먼저 블록들을 회전시킵니다
                for (Point block : blocks) {
                    int x = block.x - center.x;
                    int y = block.y - center.y;
                    block.x = center.x - y;
                    block.y = center.y + x;
                }

                // 회전이 유효하지 않을 경우 좌우로 이동을 시도합니다
                if (!isValidMove()) {
                    // 먼저 왼쪽으로 이동 시도
                    boolean moved = false;
                    for (int offset = 1; offset <= 2; offset++) {
                        // 왼쪽으로 이동
                        for (Point block : blocks) {
                            block.x -= offset;
                        }
                        if (isValidMove()) {
                            moved = true;
                            break;
                        }
                        // 원위치
                        for (Point block : blocks) {
                            block.x += offset;
                        }

                        // 오른쪽으로 이동
                        for (Point block : blocks) {
                            block.x += offset;
                        }
                        if (isValidMove()) {
                            moved = true;
                            break;
                        }
                        // 원위치
                        for (Point block : blocks) {
                            block.x -= offset;
                        }
                    }

                    // 어떤 방향으로도 이동이 불가능하면 원래 상태로 되돌립니다
                    if (!moved) {
                        for (Point block : blocks) {
                            int x = block.x - center.x;
                            int y = block.y - center.y;
                            block.x = center.x + y;
                            block.y = center.y - x;
                        }
                    }
                }
            }

            public boolean isValidMove() {
                for (Point block : blocks) {
                    if (block.x < 0 || block.x >= BOARD_WIDTH ||
                            block.y >= BOARD_HEIGHT ||
                            (block.y >= 0 && board[block.y][block.x])) {
                        return false;
                    }
                }
                return true;
            }

            public Point[] getBlocks() {
                return blocks;
            }

            public void dropToBottom() {
                while (moveDown()) ;
            }

            public Point[] getGhostPosition() {
                Point[] ghostBlocks = new Point[blocks.length];
                for (int i = 0; i < blocks.length; i++) {
                    ghostBlocks[i] = new Point(blocks[i].x, blocks[i].y);
                }

                boolean canMoveDown = true;
                while (canMoveDown) {
                    for (Point block : ghostBlocks) {
                        block.y++;
                    }

                    for (Point block : ghostBlocks) {
                        if (block.y >= BOARD_HEIGHT ||
                                (block.y >= 0 && board[block.y][block.x])) {
                            canMoveDown = false;
                            break;
                        }
                    }

                    if (!canMoveDown) {
                        for (Point block : ghostBlocks) {
                            block.y--;
                        }
                    }
                }
                return ghostBlocks;
            }

            public void drawGhost(Graphics g) {
                Point[] ghostBlocks = getGhostPosition();
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 128));

                for (Point block : ghostBlocks) {
                    g2d.drawRect(block.x * BLOCK_SIZE, block.y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }
    }
}
