package alivestill.MeiTuan;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int q = scan.nextInt();
        int[] degree = new int[n];
        Set<Integer> path = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++ i) {
            map.put(i, i);
        }
        // Robin Karp
        for (int i = 0; i < m; ++ i) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int uniqueId1 = (x - 1) * 102400 + (y - 1);
            int uniqueId2 = (y - 1) * 102400 + (x - 1);
            if (!path.contains(uniqueId1)) {
                ++degree[x - 1];
                ++degree[y - 1];
                path.add(uniqueId1);
                path.add(uniqueId2);
            }
        }
        for (int i = 0; i < q; ++ i) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int xpos = map.get(x - 1);
            int ypos = map.get(y - 1);
            map.put(x - 1, ypos);
            map.put(y - 1, xpos);

//            int temp = index[xpos];
//            index[xpos] = index[ypos];
//            index[ypos] = temp;
        }
        for (int i = 0; i < n; ++ i) {
            System.out.println(degree[map.get(i)]);
        }
    }
}
