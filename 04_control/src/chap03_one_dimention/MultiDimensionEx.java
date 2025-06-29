package chap03_one_dimention;

public class MultiDimensionEx {
    public static void main(String[] args) {
        String[][] seats = new String[3][];
        seats[0] = new String[2];
        seats[1] = new String[5];
        seats[2] = new String[4];
        
        seats[0][0] = "이동욱";
        seats[0][1] = "신성수";
        seats[1][0] = "이유천";
        seats[1][1] = "조기완";
        seats[1][2] = "최미영";
        seats[1][3] = "박진성";
        seats[1][4] = "김민석";
        seats[2][0] = "유비";
        seats[2][1] = "이창민";
        seats[2][2] = "권형택";
        seats[2][3] = "김경진";




        
        // 1) 2차원 배열 순회(일반 for문)
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + ", ");
            }
            System.out.println();
        }
        // 2) 2차원 배열 순회(향상 for문)
        for (String[] lines : seats) {
            for (String seat : lines) {
                System.out.print(seat + ", ");
            }
            System.out.println();
        }
        
        

    }
}
