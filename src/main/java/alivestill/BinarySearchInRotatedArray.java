package alivestill;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class BinarySearchInRotatedArray {

    // note, 直接考虑有重复值的情形, VALID ALGORITHM after MODIFICATION
    int search(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                if (arr[mid] >= arr[low] || target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (arr[mid] <= arr[high] || target >= arr[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /// auxiliary
//    int normalBinarySearch(int[] arr, int low, int high, int target) {
//        if (low > high) {
//            return -1;
//        }
//        while (low <= high) {
//            int mid = (low + high) / 2;
//            if (target == arr[mid]) {
//                return mid;
//            } else if (target > arr[mid]) {
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//        }
//        return -1;
//    }

    int search(int[] arr, int target) {
        if (arr.length == 0) { return -1; }
        return search(arr, 0, arr.length - 1, target);
    }


    public static void main(String[] args) {
        int[] arr = new int[] {
                15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14
        };
        int ret = new BinarySearchInRotatedArray().search(arr, 5);
        System.out.println(ret);
    }

    @Test
    public void test() {
        final int COUNT = 10000;
        final int ROUND = 10000;
        int[] arr = new int[COUNT];
        for (int i = 0; i < arr.length; ++ i) {
            arr[i] = i;
        }
        for (int i = 0; i < ROUND; ++ i) {
            int[] copy = new int[arr.length];
            System.arraycopy(arr, i, copy, 0, arr.length - i);
            System.arraycopy(arr, 0, copy, arr.length - i, i);
            Random random = new Random();
            int target = random.nextInt(COUNT);
            int pos = new BinarySearchInRotatedArray().search(copy, target);
            if (pos + i != target) {
                System.err.printf("pos = %d, i = %d, target = %d\n", pos, i, target);
            }
        }
    }

    @Test
    public void case1() {
        int[] arr = new int[] {
                1, 3
        };
        int ret = new BinarySearchInRotatedArray().search(arr, 3);
        System.out.println(ret);
    }
}
