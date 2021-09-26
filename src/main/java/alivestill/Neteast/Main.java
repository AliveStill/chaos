package alivestill.Neteast;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int ret = 0;
        int num = n;
        while (num != 0) {
            int lastBit = num % 10;
            if (lastBit != 0 && n % lastBit == 0) {
                ++ ret;
            }
            num /= 10;
        }
        System.out.println(ret);
    }
}
