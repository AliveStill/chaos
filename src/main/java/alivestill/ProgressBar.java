package alivestill;

import java.util.Random;

public class ProgressBar {

    public static void main(String[] args) throws Exception {
        final int total = 10000;
        int current = 0;
        Random random = new Random();
        StringBuffer sb = new StringBuffer(100);
        sb.append(new char[100]);
        System.out.println("SEE the progress:");
        while (current <= total) {
            current += random.nextInt(100);
            Thread.sleep(20 + random.nextInt(5));
            int percentage = current * 100 / total;
            for (int i = 0; i < 100; ++ i) {
                if (i <= percentage) {
                    sb.setCharAt(i, '#');
                } else {
                    sb.setCharAt(i, ' ');
                }
            }
            System.out.printf("\r%100s\t%d%%", sb.toString(), Math.min(percentage, 100));
        }
    }
}
