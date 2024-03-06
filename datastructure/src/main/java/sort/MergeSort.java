package sort;

import java.util.Arrays;

/**
 * 归并排序
 */

public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] a = new int[]{12,11,34,2,0,675,3234234,23432,24234,12,9,7,5,678};
      //  int[] a = new int[]{12,11,34};
        mergeSort.mergeSortInternally(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public void mergeSortInternally(int[] a, int p, int q) {
        if (p == q) {
            return;
        }
        int m = p + (q - p) / 2;
        mergeSortInternally(a, p, m);
        mergeSortInternally(a, m + 1, q);
        //排序合并
        merge(a,p,m,q);

    }

    private void merge(int[] a, int p, int m, int q) {
        int i = p;
        int j = m+1;
        // 临时存储有序数据
        int[] tmp = new int[q - p + 1];
        int k = 0;
        // 两个虚拟数组合并结束标志
        while (i <= m && j <= q) {
            if (a[i] < a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        //前半段走完
        if (i > m) {
            while (j <= q) {
                tmp[k++] = a[j];
                j++;
            }
        } else {
            while (i <= m) {
                tmp[k++] = a[i];
                i++;
            }
        }
        int tp = p;
        for (int l = 0; l < tmp.length; l++) {
            a[tp++] = tmp[l];
        }

    }


}
