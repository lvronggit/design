package tree;

class Solution {
    public static void main(String[] args) {
        ListNode l1= new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2= new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);

        System.out.println(listNode.toString());

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        int val = l1.val;
        int val1 = l2.val;

        int nex = 0;
        int start = val+val1;
        if(start>=10){
            nex = 1;
            start = start-10;
        }
        ListNode nn = null;
        ListNode listNode = nn = new ListNode(start);
        ListNode l1next = l1.next;
        ListNode l2next = l2.next;
        while (nex==1 || l1next!=null || l2next!=null){
            int v1 = 0;
            int v2 = 0;
            if(l1next != null){
                v1 = l1next.val;
                l1next = l1next.next;
            }

            if(l2next != null){
                v2 = l2next.val;
                l2next = l2next.next;
            }
            int sum = v1+ v2+nex;
            if(sum>=10){
                nex = 1;
                sum = sum-10;
            }else{
                nex = 0;
            }
            nn.next =  new ListNode(sum);
            nn = nn.next;

        }

        return listNode;
    }
}