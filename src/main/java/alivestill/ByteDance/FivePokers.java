package alivestill.ByteDance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FivePokers {
        public static void main(String[] args) {
            //Scanner in = new Scanner(System.in);
            //int a = in.nextInt();
            //System.out.println(a);
            System.out.println("Hello World!");

            int[] array = new int[] {
                    1, 2, 3, 5, 14
            };

            System.out.println(solve(array));

        }

        // lens = 5    1-15
        public static boolean solve(int[] array) {
            int kingCount = 0;
            boolean[] pokers = new boolean[13];
            Set<Integer> set = new HashSet<>();
            set.addAll(Arrays.stream(array).boxed().collect(Collectors.toList()));    // uncheked;
            for (int i = 0; i < 13; ++ i) {
                if (set.contains(i + 1)) {
                    pokers[i] = true;
                }
            }
            if (set.contains(14)) {
                ++ kingCount;
            }
            if (set.contains(15)) {
                ++ kingCount;
            }
            for (int i = 0; i < 13; ++ i) {
                int count = 0;
                for (int j = 0; j < 5 && i + j < 13; ++ j) {
                    if (pokers[i + j]) {
                        ++ count;
                    }
                }
                if (count + kingCount >= 5) {
                    return true;
                }
            }
            return false;
        }
    }
