package alivestill.HuaWeiInterview;

import java.util.*;

@Deprecated
public class Main3 {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String target = scan.nextLine();
//        Set<String> set = new HashSet<>();
//        Map<String, Integer> countMap = new HashMap<>();    // 记录入度
//        PriorityQueue<Pair<String, Integer>> queue = new PriorityQueue<>();
//        Map<String, Integer> takeTime = new HashMap<>();
//        Map<String, List<String>> dict = new HashMap<>();
//        Map<String, Pair<String, Integer>> recordMap = new HashMap<>();
//        while (scan.hasNextLine()) {
//            String[] array = scan.nextLine().split(",");
//            String name = array[0];
//            int time = Integer.parseInt(array[1]);
//            int lens = array.length;
//            if (!dict.containsKey(name)) {
//                dict.put(name, new ArrayList<>());
//            }
//            if (lens > 2) {
//                for (int i = 2; i < lens; ++ i) {
//                    String dpName = array[i];
//                    dict.get(name).add(dpName);
//                    countMap.put(dpName, countMap.getOrDefault(dpName, 0) + 1);
//                }
//            }
//            set.add(name);
//            takeTime.put(name, time);
//            countMap.put(name, lens - 2);
//        }
//
//        // now we need a priority queue
//        for (String key : countMap.keySet()) {
//            Pair<String, Integer> item = new Pair<String, Integer>(key, countMap.get(key) - 2);
//            queue.add(item);
//            recordMap.put(key, item);
//        }
//        while (!queue.isEmpty()) {
//            Pair<String, Integer> pair = queue.poll();
//
//        }
//        int ret = new Main2().solve(matrix, m, n);
//        System.out.println(ret);
//    }

    static class Pair<T1, T2> implements Comparable<T2>{
        T1 t1;
        T2 t2;

        @Override
        public int compareTo(T2 o) {
            return ((Integer)t2).compareTo((Integer)o);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return t1.equals(pair.t1) && t2.equals(pair.t2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(t1, t2);
        }

        public Pair(T1 t1, T2 t2) {
            this.t1 = t1;
            this.t2 = t2;
        }
    }
}
