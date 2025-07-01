package chap03_ex;

public class Ex10 {

  public static void main(String[] args) {
    
    // 다음 2차원 배열 T를 90도 회전하세요.

    /*
     * 1 1 1 1 1          0 0 0 0 1
     * 0 0 1 0 0          0 0 0 0 1
     * 0 0 1 0 0   --->   1 1 1 1 1
     * 0 0 1 0 0          0 0 0 0 1
     * 0 0 1 0 0          0 0 0 0 1
     * ----------------------------
     *    [0][0]   --->   [0][4]
     *    [0][1]   --->   [1][4]
     *    [0][2]   --->   [2][4]
     *    [0][3]   --->   [3][4]
     *    [0][4]   --->   [4][4]
     *   
     *    [1][0]   --->   [0][3]
     *    [1][1]   --->   [1][3]
     *    [1][2]   --->   [2][3]
     *    [1][3]   --->   [3][3]
     *    [1][4]   --->   [4][3]
     *    ...   
     * ----------------------------
     *    [i][j]   --->   [j][4-i]
     */
    
    int[][] T = {
        {1, 1, 1, 1, 1},
        {0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0}
    };

    int[][] change = new int[T[0].length][T.length];

    for (int i = 0; i < T.length; i++) {
      for (int j = 0; j < T[i].length; j++) {
        change[i][j] = T[j][4-i];
      }
    }

    for (int i = 0; i < change.length; i++) {
      for (int j = 0; j < change[i].length; j++) {
        T[i][j] = change[j][4-i];
      }
    }

    for (int i = 0; i < T.length; i++) {
      for (int j = 0; j < T[i].length; j++) {
        change[i][j] = T[j][4-i];
      }
    }

    for (int i = 0; i < change.length; i++) {
      for (int j = 0; j < change[i].length; j++) {
        System.out.print(change[i][j] + " ");
      }
      System.out.println();
    }

    
  }
  
}
