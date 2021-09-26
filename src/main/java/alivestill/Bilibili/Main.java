package alivestill.Bilibili;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[][] monsters = new long[n][2];
        if (n <= 2) {
            System.out.println(n);
            return ;
        }
        long ret = 0;
        for (int i = 0; i < n; ++ i) {
            long x1 = monsters[i][0];
            long y1 = monsters[i][1];
            for (int j = i + 1; j < n; ++ j) {
                long count = 2;
                long x2 = monsters[j][0];
                long y2 = monsters[j][1];
                for (int k = 0; k < n; ++ k) {
                    if (k == i || k == j) {
                        continue;
                    }
                    long x3 = monsters[k][0];
                    long y3 = monsters[k][1];
                    if (x1 == x2) {
                        if (x1 == x3) {
                            ++ count;
                        }
                    } else if (y1 == y2) {
                        if (y1 == y3) {
                            ++ count;
                        }
                    } else if ((y1 - y2) * (x1 - x3) == (y1 - y3) * (x1 - x2)) {
                        ++ count;
                    }
                }
                ret = Math.max(ret, count);
            }
        }
        System.out.println(ret);
    }
}

class Solutionv2 {
    
    @Test
    public void test() {
        int[][] matrix = new int[][] {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        int ret = maxPoints(matrix);
        System.out.println(ret);
    }
    public int maxPoints(int[][] points) {
        int n = points.length;
        long[][] monsters = new long[n][2];
        for (int i = 0; i < n; ++ i) {
            monsters[i][0] = points[i][0];
            monsters[i][1] = points[i][1];
        }
        if (n <= 2) {
            System.out.println(n);
            return n;
        }
        long ret = 0;
        for (int i = 0; i < n; ++ i) {
            long x1 = monsters[i][0];
            long y1 = monsters[i][1];
            for (int j = i + 1; j < n; ++ j) {
                long count = 2;
                long x2 = monsters[j][0];
                long y2 = monsters[j][1];
                for (int k = 0; k < n; ++ k) {
                    if (k == i || k == j) {
                        continue;
                    }
                    long x3 = monsters[k][0];
                    long y3 = monsters[k][1];
                    if (x1 == x2) {
                        if (x1 == x3) {
                            ++ count;
                        }
                    } else if (y1 == y2) {
                        if (y1 == y3) {
                            ++ count;
                        }
                    } else if ((y1 - y2) * (x1 - x3) == (y1 - y3) * (x1 - x2)) {
                        ++ count;
                    }
                }
                ret = Math.max(ret, count);
            }
        }
        return (int)ret;
    }
}
