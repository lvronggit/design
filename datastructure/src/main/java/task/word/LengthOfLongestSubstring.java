package task.word;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串
 */
public class LengthOfLongestSubstring {


    public int lengthOfLonges(String s) {
        Map<Character, Integer> kevalus = new HashMap<Character, Integer>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer has = kevalus.get(c);
            kevalus.put(c, i);
            if (has != null && has >= start) {
                start = has + 1;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }


    /**
     * 寻找两个数组的中位数
     */
    public void findMedianSortedArrays() {
        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{};

        /**
         * 先处理特殊情况
         * arr1.end<arr2.start
         * arr1.start>arr2.end
         */
        int length1 = arr1.length;
        int length2 = arr1.length;
        if(arr1[length1-1]>arr2[0]){
            // 偶数
            if((length1+length2)/2==0){

            }
        }
        /**
         * 非特殊情况则每次取中值
         */


    }


    public static void main(String[] args) {
        String s = "asdasdasdasdasdsaxzczxc";

        new LengthOfLongestSubstring().lengthOfLonges(s);

    }

}
