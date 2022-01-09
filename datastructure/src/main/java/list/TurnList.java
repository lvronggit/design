package list;

import java.util.LinkedList;
import java.util.List;

public class TurnList {
    public static void main(String[] args) {
        ListNode head3 = new ListNode(4,null);
        ListNode head2 = new ListNode(3,head3);

        ListNode head1 = new ListNode(2,head2);
        ListNode head = new ListNode(1,head1);

        reverseList(head);


    }
    public static ListNode reverseList(ListNode head) {
        ListNode last = null;
        ListNode cur = head;
        ListNode next ;
        while(cur != null){

            next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        return last;
    }


}
