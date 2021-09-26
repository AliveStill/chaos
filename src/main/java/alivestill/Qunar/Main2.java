package alivestill.Qunar;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class SolutionV2 {
    /* Write Code Here */
    public String solution(int[] d) {
        if (d.length == 0) {
            return "";
        }
        dfs(new ArrayList<>(), d, 0, 0, true);
        if (ret.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = ret.size() - 1; i >= 0; -- i) {
            sb.append(ret.get(i));
        }
        return sb.toString();
    }

    List<Integer> ret = new ArrayList<>();

    public void dfs(List<Integer> collector, int[] array, int pos, int sum, boolean allZero) {
        if (pos == array.length) {
            if (sum % 3 == 0) {
                if (ret.size() < collector.size()) {
                    if (ret.size() == 0) {
                        if (allZero) {
                            ret.add(0);
                        } else {
                            ret = new ArrayList<>(collector);
                            Collections.sort(ret);  // sorted
                        }
                    } else {
                        if (!allZero) {
                            ret = new ArrayList<>(collector);
                            Collections.sort(ret);  // sorted
                        }
                    }
                } else if (ret.size() == collector.size()) {
                    int index = 0;
                    List<Integer> copy = new ArrayList<>(collector);
                    Collections.sort(copy); // sorted
                    while (index < ret.size() && copy.get(index) <= ret.get(index)) {
                        if (copy.get(index) < ret.get(index)) {
                            return ;
                        }
                        ++ index;
                    }
                    if (index != ret.size()) {
                        ret = copy;
                    }
                }
            }
        } else {
            dfs(collector, array, pos + 1, sum, allZero);
            collector.add(array[pos]);
            dfs(collector, array, pos + 1, sum + array[pos], (array[pos] == 0) & allZero);
            collector.remove(collector.size() - 1);
        }
    }
}

public class Main2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _d_size = 0;
        _d_size = Integer.parseInt(in.nextLine().trim());
        int[] _d = new int[_d_size];
        int _d_item;
        for(int _d_i = 0; _d_i < _d_size; _d_i++) {
            _d_item = Integer.parseInt(in.nextLine().trim());
            _d[_d_i] = _d_item;
        }

        res = new SolutionV2().solution(_d);
        System.out.println(res);
    }
}
