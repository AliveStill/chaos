package alivestill.webank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {

    /// Is x3+y4+z5=k has valid solution?
    // note, 似乎只能用这样枚举
    // note, passed about 2/3 test cases, the cause may be integer overflow
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        long max = -1;
        for (int i = 0; i < n; ++ i) {
            array[i] = scan.nextInt();
            max = Math.max(array[i], max);
        }
        long x = 1, y = 1, z = 1;
        Set<Long> setx = new HashSet<>();
        Set<Long> sety = new HashSet<>();
        Set<Long> setz = new HashSet<>();
        while (x * x * x < max) {
            setx.add(x * x * x);
            ++ x;
        }
        while (y * y * y * y< max) {
            sety.add(y * y * y * y);
            ++ y;
        }
        while (z * z * z * z * z < max) {
            setz.add(z * z * z * z * z);
            ++ z;
        }
        Set<Long> sum = new HashSet<>();
        long[] array1 = setx.stream().mapToLong(i -> i).toArray();
        long[] array2 = sety.stream().mapToLong(i -> i).toArray();
        long[] array3 = setz.stream().mapToLong(i -> i).toArray();
        Set<Long> ret = new HashSet<>();
        for (long ele1 : array1) {
            for (long ele2 : array2) {
                for (long ele3 : array3) {
                    ret.add(ele1 + ele2 + ele3);
                }
            }
        }
        for (int i = 0; i < n; ++ i) {
            if (ret.contains((long) array[i])) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
