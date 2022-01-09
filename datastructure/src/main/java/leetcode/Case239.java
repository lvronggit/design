package leetcode;


import java.util.LinkedList;
import java.util.PriorityQueue;

public class Case239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k];
        LinkedList<Integer> linkedList = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (linkedList.getFirst() != null && linkedList.getFirst().intValue() < num) {
                linkedList.removeFirst();
            }
            linkedList.addLast(num);
            if (i >= k-1) {
                result[i - k+1] = linkedList.getFirst();
            }
        }
        return result;
    }
}
