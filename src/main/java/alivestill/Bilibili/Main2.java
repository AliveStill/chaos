package alivestill.Bilibili;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int height = scan.nextInt();
        int width = scan.nextInt();
        int[][] matrix = new int[height][width];
        for (int i = 0;i < height; ++ i) {
            for (int j = 0; j < width; ++ j) {
                matrix[i][j] = scan.nextInt();
            }
        }
        ArrayList<String> list = new ArrayList<>();
        scan.nextInt();scan.nextInt();  // useless
        int xBegin = 0, yBegin = 0;
        int xFinish = height - 1, yFinish = width - 1;
        for (;;) {
            if (xBegin > xFinish || yBegin > yFinish) {
                break;  // done
            }
            if (xBegin == xFinish) { // 1 * n
                for (int i = yBegin; i <= yFinish; ++ i) {
                    list.add(String.valueOf(matrix[xBegin][i]));
                }
                break;
            }
            if (yBegin == yFinish) { // n * 1
                for (int i = xBegin; i <= xFinish; ++ i) {
                    list.add(String.valueOf(matrix[i][yBegin]));
                }
                break;
            }
            for (int i = yBegin; i != yFinish; ++ i) {
                list.add(String.valueOf(matrix[xBegin][i]));
            }
            for (int i = xBegin; i != xFinish; ++ i) {
                list.add(String.valueOf(matrix[i][yFinish]));

            }
            for (int i = yFinish; i != yBegin; -- i) {
                list.add(String.valueOf(matrix[xFinish][i]));

            }
            for (int i = xFinish; i != xBegin; -- i) {
                list.add(String.valueOf(matrix[i][yBegin]));

            }
            ++ xBegin;
            -- xFinish;
            ++ yBegin;
            -- yFinish;
        }
        StringBuilder str = new StringBuilder(list.get(0));
        for (int i = 1; i < list.size(); ++ i) {
            str.append(",");
            str.append(list.get(i));
        }
        System.out.println(str.toString());
    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int xBegin = 0, yBegin = 0;
        int xFinish = height - 1, yFinish = width - 1;
        for (;;) {
            if (xBegin > xFinish || yBegin > yFinish) {
                break;  // done
            }
            if (xBegin == xFinish) { // 1 * n
                for (int i = yBegin; i <= yFinish; ++ i) {
                    list.add(matrix[xBegin][i]);
                }
                break;
            }
            if (yBegin == yFinish) { // n * 1
                for (int i = xBegin; i <= xFinish; ++ i) {
                    list.add(matrix[i][yBegin]);
                }
                break;
            }
            for (int i = yBegin; i != yFinish; ++ i) {
                list.add(matrix[xBegin][i]);
            }
            for (int i = xBegin; i != xFinish; ++ i) {
                list.add(matrix[i][yFinish]);

            }
            for (int i = yFinish; i != yBegin; -- i) {
                list.add(matrix[xFinish][i]);

            }
            for (int i = xFinish; i != xBegin; -- i) {
                list.add(matrix[i][yBegin]);

            }
            ++ xBegin;
            -- xFinish;
            ++ yBegin;
            -- yFinish;
        }
        return list;
    }
}
