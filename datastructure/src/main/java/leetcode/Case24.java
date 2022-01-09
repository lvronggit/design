package leetcode;

import sort.BinarySearch;

import java.lang.reflect.Constructor;
import java.util.HashSet;

// 反转链表
public class Case24 {
    public static void main(String[] args) throws ClassNotFoundException {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        ListNode three = new ListNode(3);
        two.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        ListNode five = new ListNode(5);
        four.next = five;
        ListNode six = new ListNode(6);
        five.next = six;
        Class<?> aClass = Class.forName("");
        ListNode sevene = one;

        swapPairs(null);
    }

    /**
     * 先获取链表数据
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre, cur = head, next, last = new ListNode(0), next2;
        pre = head.next;
        while (cur != null && cur.next != null) {
            next = cur.next;
            last.next = next;
            next2 = next.next;
            cur.next = next2;
            next.next = cur;
            last = cur;
            cur = next2;

        }

        return pre;
    }

    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre, next, last = new ListNode(0), next2;
        pre = head.next;
        while (head != null && head.next != null) {
            next = head.next;
            last.next = next;
            next2 = next.next;
            head.next = next2;
            next.next = head;
            last = head;
            head = next2;
        }

        return pre;
    }
}





   /* public static ListNode reverseList(ListNode head) {
        ListNode newNext = null, cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = newNext;
            newNext = cur;
            cur = next;
        }
        return newNext;
    }*/


