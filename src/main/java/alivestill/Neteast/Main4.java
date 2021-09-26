package alivestill.Neteast;

import java.util.*;

public class Main4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<Integer> visited = new HashSet<>();
        int n = scan.nextInt();
        int a = scan.nextInt();
        int b = scan.nextInt();
        scan.nextLine();    // swallow empty line
        char[][] matrix = new char[n][n];
        int[][] price = new int[n][n];
        for (int i = 0; i < n; ++ i) {
            String str = scan.nextLine();
            for (int j = 0; j < n; ++ j) {
                matrix[i][j] = str.charAt(j);
                price[i][j] = Integer.MAX_VALUE >> 1;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add((n-1) * 1024 + (n - 1));
        price[n - 1][n - 1] = 0;
        int transportMinCost = -1;
        while (!queue.isEmpty()) {
            int value = queue.remove();
            int x = value >> 10;
            int y = value % 1024;
            if (visited.contains((x << 10) + y)) {
                continue;
            }
            if (x - 1 >= 0 && !visited.contains(((x - 1) << 10) + y)) {
                int newX = x - 1;
                int newY = y;
                if (matrix[newX][newY] == '*') {
                    if (transportMinCost == -1) {   // init
                        price[newX][newY] = Math.min(price[newX][newY], price[x][y]);
                        transportMinCost = price[newX][newY];
                    } else {
                        price[newX][newY] = Math.min(price[newX][newY],
                                Math.min(price[x][y],
                                       b + transportMinCost));
                        transportMinCost = Math.min(transportMinCost, price[newX][newY]);
                    }
                } else if (matrix[newX][newY] == '#') {
                    price[newX][newY] = Math.min(price[newX][newY], price[x][y] + a);
                } else {
                    price[newX][newY] = Math.min(price[newX][newY], price[x][y]);
                }
                queue.add((newX << 10) + newY);
            }
            if (x + 1 < n&& !visited.contains(((x + 1) << 10) + y)) {
                int newX = x + 1;
                int newY = y;
                if (matrix[newX][newY] == '*') {
                    if (transportMinCost == -1) {   // init
                        price[newX][newY] = Math.min(price[newX][newY], price[x][y]);
                        transportMinCost = price[newX][newY];
                    } else {
                        price[newX][newY] = Math.min(price[newX][newY],
                                Math.min(price[x][y],
                                        b + transportMinCost));
                        transportMinCost = Math.min(transportMinCost, price[newX][newY]);
                    }
                } else if (matrix[newX][newY] == '#') {
                    price[newX][newY] = Math.min(price[newX][newY], price[x][y] + a);
                } else {
                    price[newX][newY] = Math.min(price[newX][newY], price[x][y]);
                }
                queue.add((newX << 10) + newY);
            }
            if (y - 1 >= 0 && !visited.contains(((x) << 10) + y - 1)) {
                int newX = x;
                int newY = y - 1;
                if (matrix[newX][newY] == '*') {
                    if (transportMinCost == -1) {   // init
                        price[newX][newY] = Math.min(price[newX][newY], price[x][y]);
                        transportMinCost = price[newX][newY];
                    } else {
                        price[newX][newY] = Math.min(price[newX][newY],
                                Math.min(price[x][y],
                                        b + transportMinCost));
                        transportMinCost = Math.min(transportMinCost, price[newX][newY]);
                    }
                } else if (matrix[newX][newY] == '#') {
                    price[newX][newY] = Math.min(price[newX][newY], price[x][y] + a);
                } else {
                    price[newX][newY] = Math.min(price[newX][newY], price[x][y]);
                }
                queue.add((newX << 10) + newY);
            }
            if (y + 1 < n && !visited.contains(((x) << 10) + y + 1)) {
                int newX = x;
                int newY = y;
                if (matrix[newX][newY] == '*') {
                    if (transportMinCost == -1) {   // init
                        price[newX][newY] = Math.min(price[newX][newY], price[x][y]);
                        transportMinCost = price[newX][newY];
                    } else {
                        price[newX][newY] = Math.min(price[newX][newY],
                                Math.min(price[x][y],
                                        b + transportMinCost));
                        transportMinCost = Math.min(transportMinCost, price[newX][newY]);
                    }
                } else if (matrix[newX][newY] == '#') {
                    price[newX][newY] = Math.min(price[newX][newY], price[x][y] + a);
                } else {
                    price[newX][newY] = Math.min(price[newX][newY], price[x][y]);
                }
                queue.add((newX << 10) + newY);
            }
            visited.add((x << 10) + y);
        }
        System.out.println(price[0][0]);
    }
}
