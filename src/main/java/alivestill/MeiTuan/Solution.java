package alivestill.MeiTuan;

import alivestill.CircleInLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
  }

public class Solution {
    /**
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList (ListNode head) {
        // write code here
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] array = list.stream().mapToInt(i -> i).toArray();
        Arrays.sort(array);
        ListNode tail = null;
        head = null;
        for (int ele : array) {
            if (head == null) {
                head = tail = new ListNode(ele);
            } else {
                tail.next = new ListNode(ele);
                tail = tail.next;
            }
        }
        return head;
    }

    public ListNode sortInListX (ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = null, tail= null;
        while (head != null) {
            ListNode copy = head;
            int max = head.val;
            while (copy != null) {
                max = Math.min(max, copy.val);
                copy = copy.next;
            }
            // find max
            copy = head;
            ListNode prev = null;
            while (copy != null) {
                if (copy.val == max) {
                    break;
                }
                prev = copy;
                copy = copy.next;
            }
            // head
            if (prev == null) {
                head = head.next;
                // copy == head
            } else { // nonhead
                prev.next = copy.next;
            }
            if (newHead == null) {
                newHead = tail = copy;
            } else {
                tail.next = copy;
                copy.next = null;
                tail = tail.next;
            }
        }
        return newHead;
    }

}
