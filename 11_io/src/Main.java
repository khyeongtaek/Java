import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class Main extends JFrame {
    /**
     * 스네이크 게임
     * 뱀을 조종하여 먹이를 먹고 길이를 늘리는 고전적인 게임입니다.
     * <p>
     * 게임 방법:
     * - 방향키를 사용하여 뱀을 조종합니다
     * - 빨간색 먹이를 먹으면 뱀의 길이가 늘어납니다
     * - 벽이나 자신의 몸에 부딪히면 게임이 끝납니다
     */
    private static final int CELL_SIZE = 20;  // 게임 화면의 각 셀 크기
    private static final int GRID_SIZE = 20;  // 게임 화면의 가로/세로 크기
    private static final int DELAY = 150;

    public Main() {
        add(new GamePanel());
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(GRID_SIZE * CELL_SIZE + 16, GRID_SIZE * CELL_SIZE + 39);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Main().setVisible(true));
    }

    private class GamePanel extends JPanel implements ActionListener {
        private final ArrayList<Point> snake = new ArrayList<>();
        private Point food;
        private int direction = KeyEvent.VK_RIGHT;
        private boolean running = true;
        private final Random random = new Random();
        private final Timer timer;

        public GamePanel() {
            setBackground(Color.BLACK);
            setFocusable(true);
            addKeyListener(new KAdapter());
            initGame();
            timer = new Timer(DELAY, this);
            timer.start();
        }

        private void initGame() {
            snake.clear();
            snake.add(new Point(5, 5));
            direction = KeyEvent.VK_RIGHT;
            generateFood();
        }

        private void resetGame() {
            running = true;
            initGame();
        }

        private void generateFood() {
            int x, y;
            do {
                x = random.nextInt(GRID_SIZE - 2) + 1;
                y = random.nextInt(GRID_SIZE - 2) + 1;
            } while (snake.contains(new Point(x, y)));
            food = new Point(x, y);
            if (food == null || food.x < 0 || food.x >= GRID_SIZE || food.y < 0 || food.y >= GRID_SIZE) {
                generateFood();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (running) {
                g.setColor(Color.RED);
                g.fillRect(food.x * CELL_SIZE, food.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);

                g.setColor(Color.GREEN);
                for (Point p : snake) {
                    g.fillRect(p.x * CELL_SIZE, p.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            } else {
                gameOver(g);
            }
        }

        private void gameOver(Graphics g) {
            String msg = "Game Over";
            String restart = "Press 'R' to Restart";
            g.setColor(Color.WHITE);
            g.setFont(new Font("Helvetica", Font.BOLD, 14));
            FontMetrics fm = getFontMetrics(g.getFont());
            g.drawString(msg, (GRID_SIZE * CELL_SIZE - fm.stringWidth(msg)) / 2, GRID_SIZE * CELL_SIZE / 2);
            g.drawString(restart, (GRID_SIZE * CELL_SIZE - fm.stringWidth(restart)) / 2, GRID_SIZE * CELL_SIZE / 2 + 20);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (running) {
                move();
                checkCollision();
                checkFood();
            }
            repaint();
        }

        // 뱀의 이동을 처리하는 메소드
        private void move() {
            Point head = snake.get(0);
            Point newHead = new Point(head);

            switch (direction) {
                case KeyEvent.VK_LEFT -> newHead.x--;
                case KeyEvent.VK_RIGHT -> newHead.x++;
                case KeyEvent.VK_UP -> newHead.y--;
                case KeyEvent.VK_DOWN -> newHead.y++;
            }

            snake.add(0, newHead);
            snake.remove(snake.size() - 1);
        }

        private void checkCollision() {
            Point head = snake.get(0);
            if (head.x < 0 || head.x >= GRID_SIZE || head.y < 0 || head.y >= GRID_SIZE) {
                running = false;
                return;
            }

            for (int i = 1; i < snake.size(); i++) {
                if (head.equals(snake.get(i))) {
                    running = false;
                    break;
                }
            }
        }

        private void checkFood() {
            if (snake.get(0).equals(food)) {
                snake.add(new Point(snake.get(snake.size() - 1)));
                generateFood();
                System.out.println("츄릅~~ 뱀사이즈 : " + snake.size());
            }
        }

        private class KAdapter extends KeyAdapter {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if ((key == KeyEvent.VK_LEFT) && (direction != KeyEvent.VK_RIGHT)) {
                    direction = KeyEvent.VK_LEFT;
                } else if ((key == KeyEvent.VK_RIGHT) && (direction != KeyEvent.VK_LEFT)) {
                    direction = KeyEvent.VK_RIGHT;
                } else if ((key == KeyEvent.VK_UP) && (direction != KeyEvent.VK_DOWN)) {
                    direction = KeyEvent.VK_UP;
                } else if ((key == KeyEvent.VK_DOWN) && (direction != KeyEvent.VK_UP)) {
                    direction = KeyEvent.VK_DOWN;
                } else if (key == KeyEvent.VK_R && !running) {
                    resetGame();
                }
            }
        }
    }
}
