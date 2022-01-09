package tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 验证是否是二叉树
 */
public class CheckBinTreeNode {

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap();

        for(int i = 0;i<nums.length;i++){
            map.put(Integer.valueOf(nums[i]),Integer.valueOf(i));
        }

        for(int j = 0;j<nums.length;j++){
            Integer  check = target-nums[j];
            Integer index = map.get(check);
            if(index!=null &&  index.equals(j)  ){
                return new int[]{j,index};
            }
        }
        return null;
    }
}
