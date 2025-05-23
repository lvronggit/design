package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 20230626 写的
     * 从左到右进行比较，每一轮会比较出最大或最小的数据 n*n时间复杂度 空间复杂度n
     *
     * @param sort
     * @return
     */
    public static int[] sort(int[] sort) {
        int length = sort.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (sort[j] > sort[i]) {
                    int mid = sort[i];
                    sort[i] = sort[j];
                    sort[j] = mid;
                }
            }
        }
        return sort;
    }







        public static int[] sortBreake(int[] sort) {
     /**
     * 需要进行多少轮的排序
     */
        for (int i = 0; i < sort.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < sort.length - i - 1; j++) {
                int tem = sort[j];
                if (sort[j] > sort[j + 1]) {
                    flag = true;
                    sort[j] = sort[j + 1];
                    sort[j + 1] = tem;
                }
            }

    /**
     * 如果有一次没交换数据,则表示后面是有序的
     */
            if (!flag) {
                break;
            }
        }
        return sort;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(BubbleSort.sort(new int[]{122, 123, 22, 1212, 12, 213123, 1})));


    }
}
