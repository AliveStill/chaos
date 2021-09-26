package alivestill.Alibaba;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; ++ i) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int diff = Math.abs(a - b);
            int ret = solve(diff);
            System.out.println(ret);
        }
    }

    @Test
    public void test() {
        System.out.println(solve(11));  // should be 5
        System.out.println(solve(6));   // should be 3
    }

    static int solve(int diff) {
        if (diff == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int k = 1;
        while (!set.isEmpty()) {
            int[] array = set.stream().mapToInt(i -> i).toArray();
            Set<Integer> newSet = new HashSet<>();
            for (int i = 0; i < array.length; ++ i) {
                if (set.contains(diff)) {
                    return  k - 1;
                } else {
                    newSet.add(array[i] + k);
                    newSet.add(array[i] - k);
                }
            }
            set = newSet;
            ++ k;
        }
        return -1;
    }
}
