package alivestill.Alibaba;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Main2 {

    static int A, B, C, D;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        A = scan.nextInt();
        B = scan.nextInt();
        C = scan.nextInt();
        D = scan.nextInt();
        int n = scan.nextInt();
        for (int i = 0; i < n; ++ i) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            System.out.println(solve(x, y, TYPE.A));
        }
    }

    @Test
    public void test() {
        A = 1;B = 2; C = 3;D = 4;
        System.out.println(solve(4, 5, TYPE.A));
    }

    enum  TYPE {
        A(0),
        B(1),
        C(2),
        D(3);

        int value;
        TYPE(int value) {
            this.value = value;
        }
    }

    /// type = 1, A
    /// type = 2, B
    /// type = 3, C
    /// type = 4, D
    static int solve(int x, int y, TYPE type) {
        if (x <= 2 && y <= 2) {
            if (type == TYPE.A) {
                return A;
            } else if (type == TYPE.B) {
                return B;
            } else if (type == TYPE.C) {
                return C;
            } else if (type == TYPE.D) {
                return D;
            }
            return 0;   // never happen
        }

        int bound = 1;
        while (Math.max(x, y) > bound) {    // ensure bound
            bound <<= 1;
        }

        int halfBound = bound >>> 1;
        if (x <= halfBound && y <= halfBound) { /* type A */
            return solve(x, y, TYPE.A);
        } else if (x <= halfBound && y > halfBound) { /* type B */
            return solve(x, y - halfBound, TYPE.A) + solve(x, y - halfBound, TYPE.B);
        } else if (x > halfBound && y <= halfBound) { /* type D */
            return solve(x - halfBound, y, TYPE.A) + solve(x - halfBound, y, TYPE.D);
        } else if (x > halfBound && y > halfBound) { /* type C */
            return solve(x - halfBound, y - halfBound, TYPE.A) + solve(x - halfBound, y - halfBound, TYPE.C);
        }

        return 0;   // never happen
    }
}
