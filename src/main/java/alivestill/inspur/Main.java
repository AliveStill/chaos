package alivestill.inspur;

import java.util.Scanner;
import java.util.Arrays;

class Main {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String[] str = scan.nextLine().trim().split("#");
        int[] nums = new int[3];
        for (int i = 0; i < 3; ++ i) {
            nums[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(nums);
        System.out.print(nums[0] + "#" + nums[1] + "#" + nums[2]);
    }
}
