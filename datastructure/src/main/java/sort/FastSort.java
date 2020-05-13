package sort;

import java.util.Arrays;

/**
 * 快速排序算法
 */
public class FastSort {


    /**
     * 思想：  将数据分段,对每段进行排序、
     * <p>
     * {12,212,1233,666,7777,11}
     * {12,212,1233} {666,7777,11}
     * <p>
     * <p>
     * 基本思想是：
     * <p>
     * 1．先从数列中取出一个数作为基准数。
     * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
     * 3．再对左右区间重复第二步，直到各区间只有一个数。
     */
    static int[] AdjustArrayByLast(int s[], int p, int q) //返回调整后基准数的位置
    {
        if (p < q) {
            /**选举最后一个作为中间位*/
            int provide = s[q];
            int i = p, j = q;
            // 对数据进行两边遍历，直到位置在同一个地方的时候停止
            while (i < j) {
                while (i < j && s[i] < provide) {
                    i++;
                }
                // 找到比选举的数据大的数据放在右边
                if (i < j) {
                    s[j] = s[i];
                    j--;
                }
                while (i < j && s[j] >= provide) {
                    j--;
                }
                // 找到比选举数据小的放在左边
                if (i < j) {
                    s[i] = s[j];
                    i++;
                }
            }
            s[i] = provide;
            AdjustArrayByLast(s, p, i - 1);
            AdjustArrayByLast(s, i + 1, q);
            System.out.println(Arrays.toString(s));
        }
        return s;
    }


    public static void main(String[] args) {
        FastSort.AdjustArrayByLast(new int[]{1112, 11, 13, 3123, 444, 5554, 1321, 12312, 2123, 1312}, 0, 9);


    }

}
