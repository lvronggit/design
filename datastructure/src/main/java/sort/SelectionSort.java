package sort;/*
 * Copyright (C), 2002-2025, 汇付天下
 * FileName: SelectionSort.java
 * Author:   rong.lv
 * Date:     2025/1/10 17:21
 * Description: //模块目的、功能描述
 */

import java.util.Arrays;

/**
 * 选择排序
 * 一部分为已经排序的，另外一部分选出最小的数据放在已经排序的右边
 */
public class SelectionSort {

    public static int[] selectSort(int[] disorder, int left, int right) {
        if (left >= right) {
            return disorder;
        }
        //取值进行排序
        int minvalue = disorder[right];
        int lf = left;
        int ri = right;
        while (lf < ri) {
            // 从左开始找大于minvalue的
            while (disorder[lf] < minvalue && lf < ri) {
                lf++;
            }
            if (lf < ri) {
                disorder[ri] = disorder[lf];
                ri--;
            }
            // 从右开始找小于minvalue的值
            while (disorder[ri] >= minvalue && lf < ri) {
                ri--;
            }
            if (lf < ri) {
                disorder[lf] =    disorder[ri];
                lf++;
            }
            // 交换数据
        }
        disorder[ri] = minvalue;
        System.out.println(Arrays.toString(disorder));
        selectSort(disorder, left, lf-1);
        selectSort(disorder, lf + 1, right);
        return disorder;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(SelectionSort.selectSort(new int[]{23, 999, 1582, 1, 12, 12121, 123, 1213, 888},0,8)));
    }
}
