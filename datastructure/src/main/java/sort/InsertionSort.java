package sort;

import java.util.Arrays;

/**
 * 插入排序  数组分成排序的和未排序的两部分,刚开始只有第一个元素是排序的
 */
public class InsertionSort {

    public static int[] sort(int [] sort){
        for (int i = 0;i< sort.length;i++){
            for (int j = i+1;j<sort.length;j++){
                if(sort[i] > sort[j]){
                    int tem = sort[i];
                    sort[i] = sort[j];
                    sort[j] = tem;
                }
            }

        }

        return sort;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(InsertionSort.sort(new int[]{1,12,12121,123,1213,12321})));
    }
}
