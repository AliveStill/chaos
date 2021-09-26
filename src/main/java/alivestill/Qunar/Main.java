package alivestill.Qunar;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {
    /* Write Code Here */
    public int solution(int[] arr) {
        int lens = arr.length;
        if (lens == 0) {
            return 0;
        }
        Arrays.sort(arr);
        if (arr[lens - 1] <= 0) {
            return 0;   // choose none of them
        }
        int[] postfixSum = new int[lens];
        postfixSum[lens - 1] = arr[lens - 1];
        for (int i = lens - 2; i >= 0; -- i) {
            postfixSum[i] = postfixSum[i + 1] + arr[i];
        }
        int sum = 0;
        int ret = 0;
        for (int i = lens - 1; i >= 0; -- i) {
            sum += postfixSum[i];
            ret = Math.max(ret, sum);
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        res = new Solution().solution(_arr);
        System.out.println(String.valueOf(res));

    }
}
