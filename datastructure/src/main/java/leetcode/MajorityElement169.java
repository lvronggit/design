package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 求出出现次数最多的元素
 */
public class MajorityElement169 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countmaps = new HashMap<>();
        int maxcount = 0;
        Integer max = null;
        for (int i = 0; i < nums.length; i++) {
            Integer num = nums[i];
            Integer count = countmaps.get(num);
            count = count==null?1:count+ 1;
            countmaps.put(num, count);
            if(count>maxcount){
                maxcount = count;
                max = num;
            }
        }
        return max;

    }
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> countmaps = new HashMap<>();
        int maxcount = 0;
        Integer max = null;
        for (int i = 0; i < nums.length; i++) {
            Integer num = nums[i];
            Integer count = countmaps.get(num);
            count = count==null?1:count+ 1;
            countmaps.put(num, count);
            if(count>maxcount){
                maxcount = count;
                max = num;
            }
        }
        return max;

    }


}
