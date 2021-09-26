package alivestill.webank;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int height = scan.nextInt();
        int width = scan.nextInt();
//        String[] nums = scan.nextLine().split(" ");
        int x = scan.nextInt(); // change direction
        int y = scan.nextInt(); // stay there
//        int x = Integer.parseInt(nums[0]);
//        int y = Integer.parseInt(nums[1]);
        int[][] matrix = new int[height][width];
        for (int i = 0; i < height; ++ i) {
            for (int j = 0; j < width; ++ j) {
                matrix[i][j] = scan.nextInt();
            }
        }
        String str = scan.nextLine();

        solve(matrix, str, height, width, x, y);
    }

    @Test
    public void test() {
        int height = 2;
        int width = 2;
        int x = 2;
        int y = 2;
        int[][] matrix = new int[][] {{1, 2}, {-1, 3}};
        solve(matrix, "kjljk", height, width, x, y);
    }


    public static void solve(int[][] matrix, String str, int height, int width, int x, int y) {
        int curX = 0, curY = 0;
        int price = 0;
        for (int i = 0; i < str.length(); ++ i) {
            // only right and down allowed
            if (i == 0) {
                if (str.charAt(i) == 'l') { /* right */
                    if (curY == width - 1 || matrix[curX][curY + 1] == -1) {
                        price += y;
                    } else {
                        price += Math.max(matrix[curX][curY], matrix[curX][curY + 1]);
                        ++ curY;
                    }
                } else if (str.charAt(i) == 'j') { /* down */
                    if (curX == height - 1 || matrix[curX + 1][curY] == -1) {
                        price += y;
                    } else {
                        price += Math.max(matrix[curX][curY], matrix[curX + 1][curY]);
                        ++ curX;
                    }
                } else {
                    // else stay
                    price += y;
                }
            } else {
                if (str.charAt(i - 1) != str.charAt(i)) {
                    price += x;
                }
                if (str.charAt(i) == 'h') {  /* left */
                    if (curY == 0 || matrix[curX][curY - 1] == -1) {
                        price += y;
                    } else {
                        price += Math.max(matrix[curX][curY], matrix[curX][curY - 1]);
                        -- curY;
                    }
                } else if (str.charAt(i) == 'l') { /* right */
                    if (curY == width - 1 || matrix[curX][curY + 1] == -1) {
                        price += y;
                    } else {
                        price += Math.max(matrix[curX][curY], matrix[curX][curY + 1]);
                        ++ curY;
                    }
                } else if (str.charAt(i) == 'k') { /* up */
                    if (curX == 0 || matrix[curX - 1][curY] == -1) {
                        price += y;
                    } else {
                        price += Math.max(matrix[curX][curY], matrix[curX - 1][curY]);
                        -- curX;
                    }
                } else if (str.charAt(i) == 'j') { /* down */
                    if (curX == height - 1 || matrix[curX + 1][curY] == -1) {
                        price += y;
                    } else {
                        price += Math.max(matrix[curX][curY], matrix[curX + 1][curY]);
                        ++ curX;
                    }
                }
            }
        }
        System.out.println(price);
    }
}
