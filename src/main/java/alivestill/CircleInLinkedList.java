package alivestill;

public class CircleInLinkedList {
    // note, 快慢指针同时运行，直到相遇，然后快指针重新直线链表头，
    //  以相同的速度前进（慢速，一次前进一个），相遇时指向的节点就是环的入口
        public ListNode detectCycle(ListNode head) {
            if(head==null||head.next==null)
                return null;
            ListNode fast=head,slow=head;
            while(fast!=null){
                fast=fast.next;
                if(fast!=null){
                    fast=fast.next;
                }else{
                    return null;
                }
                slow=slow.next;
                if(slow==fast)
                    break;
            }
            if(fast==null||slow==null)
                return null;
            fast=head;
            while(fast!=slow){
                fast=fast.next;
                slow=slow.next;
            }
            return fast;
        }

        class ListNode {
            int val;
            ListNode next;
        }
}
