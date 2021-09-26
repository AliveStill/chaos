package alivestill.HuaWeiInterview;

 import org.junit.jupiter.api.Test;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] line = scan.nextLine().split(",");
        int m = Integer.parseInt(line[0]); // height
        int n = Integer.parseInt(line[1]); // width
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; ++ i) {
            for (int j = 0; j < n; ++ j) {
                matrix[i][j] = scan.nextInt();
            }
        }

        int ret = new Main2().solve(matrix, m, n);
        System.out.println(ret);
    }

    @Test
    public void test() {
        int[][] matrix = new int[][] {
                {3, 2, 2}, {0, 1, 0}, {1, 1, 1}
        };
        int ret = new Main2().solve(matrix, 3, 3);
        System.out.println(ret);
    }

    int solve(int[][] matrix, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (matrix[m - 1][n - 1] == 0) {
            return -1;
        }
        int[][] table = new int[m][n];
        for (int i = 0; i < m; ++ i) {
            for (int j = 0; j < n; ++ j) {
                table[i][j] = -1;   // not reachable
            }
        }
        table[0][0] = 0;
        for (int i = 0; i < m; ++ i) {
            for (int j = 0; j < n; ++ j) {
                if (table[i][j] != -1 && matrix[i][j] != 0) {
                    int gap = matrix[i][j];
                    for (int k1 = 1; k1 + j<= gap && k1 + j< n; ++ k1) {
                        if (matrix[i][k1 + j] == 0) {    // not reachable
                            continue;
                        }
                        if (table[i][k1 + j] == -1) {
                            table[i][k1 + j] = table[i][j] + 1;
                        } else {
                            table[i][k1 + j] = Math.min(table[i][k1 + j], table[i][j] + 1);
                        }
                    }
                    for (int k2 = 1; k2 + i <= gap && k2 + i< m; ++ k2) {
                        if (matrix[k2 + i][j] == 0) {
                            continue;  // not reachable
                        }
                        if (table[k2 + i][j] == -1) {
                            table[k2 + i][j] = table[i][j] + 1;
                        } else {
                            table[k2 + i][j] = Math.min(table[k2 + i][j], table[i][j] + 1);
                        }
                    }
                }
            }
        }
        return table[m - 1][n - 1];
    }

}
