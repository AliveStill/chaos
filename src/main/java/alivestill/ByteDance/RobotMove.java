package alivestill.ByteDance;

public class RobotMove {
        public static void main(String[] args) {
            //Scanner in = new Scanner(System.in);
            //int a = in.nextInt();
            //System.out.println(a);
            System.out.println("Hello World!");

            System.out.println(new RobotMove().solve(2, 3, 1));
            System.out.println(new RobotMove().solve(3, 1, 0));
        }

        int solve(int m, int n, int threshold) {
            height = m;
            width = n;
            visited = new boolean[height][width];
            dfs(0, 0, threshold);
            return count;
        }

        int count = 0;
        int width;
        int height;
        boolean[][] visited;

        void dfs(int xpos, int ypos, int threshold) {
            if (xpos < 0 || xpos >= height || ypos < 0 || ypos >= width) {
                return ;
            }
            if (visited[xpos][ypos]) {
                return ;
            }
            visited[xpos][ypos] = true; // note。放在这里能够加速，否则放在下一行之后会多次进入某个已经确定不合法的节点
            if (!checkValid(xpos, ypos, threshold)) {
                return ;
            }
            ++ count;
            dfs(xpos + 1, ypos, threshold);
            dfs(xpos - 1, ypos, threshold); // can be ignored
            dfs(xpos, ypos + 1, threshold);
            dfs(xpos, ypos - 1, threshold); // can be ignored
            // note！！，在这种特定的情况下，比如数据连续分布在matrix的左上角，可以简化成两个方向，
            //  但是考虑另一种并非连续的情况：xxoxx
            //                           xxoxx
            //                          xoooxx
            //                          xxxxxx
            //                          比如这种勾字形的情形就必须用四个方向的dfs
        }

        public boolean checkValid(int x, int y, int threshold) {
            int count = 0;
            while (x != 0) {
                count += x%10;
                x /= 10;
            }
            while (y != 0) {
                count += y % 10;
                y /= 10;
            }
            return count <= threshold;
        }
}
