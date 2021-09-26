package alivestill;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int[]arr = new int[] {7, 6, 5, 4, 4, 3, 5, 6, 9, 2, 4};
        quickSort(arr, 0, arr.length - 1);
        for (int ele : arr) {
            System.out.println(ele);
        }
    }

    @Test
    @DisplayName("already passed")
    public void pressure() {
        final int ROUND = 10000;
        final int NNUM = 100000;
        Random random = new Random(NNUM >>> 5);
        for (int i = 0; i < ROUND; ++ i) {
            int[] array = new int[NNUM];
            for (int j = 0; j < NNUM; ++ j) {
                array[j] = random.nextInt();
            }
            quickSort(array, 0, array.length - 1);
            for (int j = 0; j < NNUM - 1; ++ j) {
                if (array[j] > array[j + 1]) {
                    System.err.println("INVALID");
                    System.exit(-1);
                }
            }
            System.out.printf("%2.2f%%, valid\n", (double)(i + 1) * 100 / ROUND );
        }
    }


    static void quickSort(int[] arr, int left, int right) {
        // if （left >= right) return;
        int index = partition(arr, left, right);
        if (left < index - 1) {
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        while (left <= right) {
            while (arr[left] < pivot) left++;

            while (arr[right] > pivot) right--;

            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left ++ ;
                right --;
            }
        }
        return left;
        // note，首先明确，由left经过的路径值都是小于等于base的，right经过的路径值都是大于等于base的
        // note， 1，首先证明大的while不可能陷入死循环，因为left只能往右，right只能往左，
        //  所以使其陷入无限循环的话每一轮left和right不能动，即left总是指向一个大于等于pivot的值，
        //  right总是指向一个小于等于pivot的值，此时if成立，二者步进，所以while不可能死循环
        //  2。其次证明返回时left之前的元素总是小于等于left及其之后的元素，这个比较复杂，
        //  自己脑子里想一下怎么回事，四种情形：
        //      a,      OO
        //          left right,二者交换彼此步进
        //      b,      OxO
        //          left right，二者交换之后指向同一个位置，此时又区分这个位置的数是大于等于还是小于base，三种情形都成立
        //      c,  0       《-
        //          left    right，left固定，right向左前进，这种情况成立
        //      d,  -》      0
        //          left    right， right固定，left向由前进，这种情况也成立
        //  3。其次证明qsort函数总能停止,长度为0或者1的子数组总是能停止，子数组总是比原来的规模要小，
        //  证明：只有返回的index值为left或者right时划分的子数组一个规模为0， 另一个为（rihgt - left + 1）
        //  即规模不变，显然index为right时第二个if不成立，第一个if将规模缩小了，考虑index为left时第一个if
        //  不成立，所以仅需要考虑index==left时的情形：当index返回值为left时仅有一种情况，part函数中left
        //  指针始终停留在初始位置，而right指针一直向左跨过了left指针直到right == left - 1，
        //  因为一旦rihgt发现一个小于等于pivot的数二者会交换而left会向前移动，而pivot存在于该数组中，
        //  所以right指针始终无法跨过left，所以index不可能等于left
    }
}
