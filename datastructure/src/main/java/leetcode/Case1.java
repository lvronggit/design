package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Case1 {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        Map<Integer,Integer> checks = new HashMap<>();


    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> checks = new HashMap<>();
        int length = nums.length;
        for(int i = 0;i<length;i++){
            if(checks.containsKey(nums[i])){
                return new int[]{i,checks.get(nums[i])};
            }
            checks.put(target- nums[i],i);
        }
        return new int[2];
    }
}
