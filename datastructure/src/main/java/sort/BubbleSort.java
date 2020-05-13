package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {



    public static int[] sort(int[] sort){
        /**
         * 需要进行多少轮的排序
         */
        for (int i = 0;i<sort.length-1;i++){
            boolean flag = false;
            for (int j = 0;j<sort.length-i-1;j++){
                int tem = sort[j];
                if(sort[j]>sort[j+1]){
                    flag = true;
                    sort[j] = sort[j+1];
                    sort[j+1] = tem;
                }
            }
            /**
             * 如果有一次没交换数据,则表示后面是有序的
             */
            if(!flag){
                break;
            }
        }
        return sort;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString( BubbleSort.sort(new int[]{122,123,22,1212,12,213123,1})));


    }
}
