package alivestill;

public class FloydWarshall {
    // note，自己到自己为0，不通为无穷大
    public int[][] calculate(int[][] graph) {
        if (graph == null) {
            return null;
        }
        int lens = graph.length;
        int[][] dist = new int[lens][lens];
        if (lens == 0) {
            return null;
        }
        // copy
        for (int i = 0; i < lens; ++ i) {
            System.arraycopy(graph[i], 0, dist[i], 0, lens);
        }
        for (int k = 0; k < lens; ++ k) {
            for (int i = 0; i < lens; ++ i) {
                for (int j = 0; j < lens; ++ j) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        return dist;
    }
}

