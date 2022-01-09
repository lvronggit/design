package leetcode;

import array.queue.Queue;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;

public class Case703 {

    int[] nums;
    int k;
    PriorityQueue<Integer> priorityQueue  ;
    public Case703(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>(k);
        this.nums = nums;
        this.k = k;
        for (int i=0;i<nums.length;i++){
            add(nums[i]);
        }

    }

    public int add(int val) {
        int size = priorityQueue.size();
        if (size < k) {
            priorityQueue.add(val);
        } else {
            Integer poll = priorityQueue.peek();
            if (val > poll) {
                priorityQueue.remove();
                priorityQueue.add(val);
            }

        }
        return priorityQueue.peek();
    }


    public static void main(String[] args) {

        Case703 kthLargest = new Case703(3,new int[]{4, 5, 8, 2});
        kthLargest.add(3);   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8

    }

}
