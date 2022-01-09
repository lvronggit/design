package stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 滑动窗口算出最大值
 */
public class Slidmax {

    public static  int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
            /**
             * 双端队列对数据进行处理，达到 队列中数据从大到小排列
             * 每次插入数据到队列中清除比自己小的数据
             * 队列存储下标，用来判断数据是否可以移除队列
             */
            while (!queue.isEmpty() && nums[queue.getFirst()] <= nums[i]) {
                queue.removeFirst();
            }

            queue.addFirst(i);

            if(queue.getLast()<=i-k){
                queue.removeLast();
            }

            if (i >= (k - 1)) {
                res[i - k+1] = nums[queue.getLast()];
            }

        }
        return res;

    }

    public static void main(String[] args) {
       int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));

    }
}
