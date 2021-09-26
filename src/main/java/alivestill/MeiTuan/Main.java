package alivestill.MeiTuan;


import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    // note, uncertain test cases, not for sure
    // note, partial correct, 27% passed test cases, Mainly TLE
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int lens = str.length();
        int ret = 0;
        BigInteger num = new BigInteger(String.valueOf(22));
        BigInteger zero = new BigInteger(String.valueOf(0));
        Set<BigInteger> accept = new HashSet<>();
        Set<BigInteger> reject = new HashSet<>();
        for (int i = 0; i < lens; ++ i) {
            // skip leading zero
            if (str.charAt(i) == '0') {
                continue;
            }
            for (int j = i + 1; j < lens; ++ j) {
                // skip odd numbers
                if (((int)str.charAt(i) & 1) == 1) {
                    continue;
                }
                BigInteger div = new BigInteger(str.substring(i, j + 1));
                if (accept.contains(div)) {
                    ++ ret;
                }
                else if (reject.contains(div)) {
                    continue;
                } else if (!div.equals(zero)
                        && (div.mod(num).equals(zero))) {
                    ++ ret;
                    accept.add(div);
                } else {
                    reject.add(div);
                }
            }
        }
        System.out.println(ret);
    }
}
