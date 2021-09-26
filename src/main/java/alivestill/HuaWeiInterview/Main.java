package alivestill.HuaWeiInterview;



import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, TreeNode> map = new HashMap<>();
        int n = scan.nextInt();
        for (int i = 0; i < n; ++ i) {
            int value = scan.nextInt();
            map.put(i, new TreeNode(i, value));
        }
        Set<Integer> hasLeftChild = new HashSet<>();
        while (scan.hasNextInt()) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            if (hasLeftChild.contains(x)) {
                map.get(x).right = map.get(y);
            } else {
                map.get(x).left = map.get(y);
            }
            hasLeftChild.add(x);
        }

        int ret = new Main().solve(map.get(0));
        System.out.println(ret);
    }

//    @Test
//    public void test() {
//        TreeNode node1 = new TreeNode(0, 4);
//        TreeNode node2 = new TreeNode(1, 9);
//        TreeNode node3 = new TreeNode(2, -7);
//        TreeNode node4 = new TreeNode(3, -8);
//        node1.left = node2;
//        node1.right = node4;
//        node2.left = node3;
//        int ret = new Main().solve(node1);
//        System.out.println(ret);
//    }

    int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return val + leftSum + rightSum;
    }

    int total;
    TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();

    int solve(TreeNode root) {
        if (root == null) {
            return -1;
        }
        total = sum(root);
        travel(root);
        int lastKey = map.lastKey();
        TreeSet<Integer> lastSet = map.get(lastKey);
        if (lastSet.size() == 1 && lastSet.contains(root.id)) {
            map.remove(lastKey);
            return map.get(map.lastKey()).first();
        } else {
            return map.get(map.lastKey()).first();
        }
    }

    // return sum of current node + all it's descendants
    int travel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = travel(root.left);
        int rightSum = travel(root.right);
        int sum = leftSum + rightSum + root.val;
        int remain = total - sum;
        int ret = Math.abs(sum - remain);
        if (!map.containsKey(ret)) {
            map.put(ret, new TreeSet<>());
        }
        Set<Integer> set = map.get(ret);
        set.add(root.id);
        return sum;
    }
}

class TreeNode {
    int id;
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int id, int val) {
        this.id = id;
        this.val = val;
        left = null;
        right = null;
    }
}
