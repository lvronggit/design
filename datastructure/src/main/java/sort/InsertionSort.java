package sort;

import java.util.Arrays;

/**
 * 插入排序  数组分成排序的和未排序的两部分,刚开始只有第一个元素是排序的
 */
public class InsertionSort {


    public static int[] insertSort(int[] disorder) {
        if (disorder.length <= 1) {
            return disorder;
        }
        for (int i = 1; i < disorder.length; i++) {
            int data = disorder[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (data < disorder[j]) {
                    disorder[j + 1] = disorder[j];
                } else {
                    break;
                }
            }
            // 给未赋值的地方赋值
            disorder[j + 1] = data;
        }
        return disorder;

    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(InsertionSort.insertSort(new int[]{23, 999, 888, 1, 12, 12121, 123, 1213, 12321})));
    }
}
