package likou;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n))
 */
public class FindMiddle {

    /**
     * 结题思路
     * <p>
     * 先处理特殊场景
     * 末尾大于或小于起始
     */
    public static void main(String[] args) {


    }

    public double mid(int[] num1, int[] num2) {
        int num1mid = num1.length / 2;
        int num2mid = num2.length / 2;

        while (true){
            if(num1[num1mid] > num2[num2mid]){
                num1mid = num1mid/2;
                num2mid = num2mid/2+num2mid;
            }else {


            }
        }


    }


}
