package alivestill.HuaWeiInterview;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solve {

    List<String> list = new ArrayList<>();

    public List<String> solve(int n) {
        StringBuilder str = new StringBuilder();
        dfs(str, 0, 0, n);
        return list;
    }

    public void dfs(StringBuilder str, int leftCount, int rightCount, int limit) {
        if (rightCount > leftCount) {
            return ;
        }
        if (leftCount > limit || rightCount > limit) {
            return ;
        }

        if (leftCount + rightCount == limit * 2) {
            if (leftCount == rightCount) {
                list.add(str.toString());
            }
            return ;
        }
        str.append("(");
        dfs(str, leftCount + 1, rightCount, limit);
        str.deleteCharAt(str.length() - 1);
        str.append(")");
        dfs(str, leftCount, rightCount + 1, limit);
        str.deleteCharAt(str.length() - 1);
    }

    @Test
    public void test() {
        List<String> ret = solve(4);
        for (String str : ret) {
            System.out.println(str);
        }
    }
}
