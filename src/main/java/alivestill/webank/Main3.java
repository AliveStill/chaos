package alivestill.webank;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; ++ i) {
            array[i] = scan.nextInt();
        }
        int ret = 0;
        for (int i = 0; i < n; ++ i) {
            if (i == 0) {
                System.out.println(array[i]);
            } else {
                if ((array[i] & 1) == 1) {
                    System.out.println(array[i] - array[i - 1]);
                } else {
                    System.out.println(array[i - 1] - array[i]);
                }
            }
        }
    }
}
