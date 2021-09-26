package alivestill.Neteast;

import java.util.Scanner;

public class Main2 {

    // pretty difficult
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int copy = num;

        if (num == 0) {
            System.out.println(0);
            return ;
        }

        if ((num & (num - 1)) == 0) {
            System.out.println(1);
            return ;
        }

        // may pass partial test cases.
        int output = 0;
        while (num != 0) {
            num &= (num - 1);
            ++ output;
        }

        int pos = 30;
        while (((1 << pos) & copy) == 0) {
            pos--;
        }

        System.out.println(Math.min(3 + pos - output, output));
        // System.out.println(output);
    }
}
