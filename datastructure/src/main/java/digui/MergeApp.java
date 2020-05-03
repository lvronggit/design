package digui;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeApp {


    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 50,112};
        int[] B = new int[]{3,22, 34,123,1213};
        int[] C = new int[A.length+B.length];
        MergeApp mergeApp = new MergeApp();
        //将两个有序数组归并到一个数组
        mergeApp.merge(A, B, C);
        System.out.println(Arrays.toString(C));
    }

    private void merge(int[] A, int[] B, int[] C) {
        mergeapp(A, B, C);
    }

    // 数组small的长度小于数据smaller
    private void mergeapp(int[] small, int[] smaller, int[] C) {
        int indexA = 0,indexB=0, indexC = 0;
        int sizeA = small.length;
        int sizeB = smaller.length;
        // A或者B的index小于对应数组的长度则继续,当一方结束的时候则将另外一个全部复制到数组中
        while ((indexA<sizeA) && (indexB<sizeB)) {
            if(small[indexA] <= smaller[indexB]){
                C[indexC] = small[indexA];
                indexA++;
                if(indexA == sizeA){
                    indexC++;
                    put(smaller,indexB,C,indexC);
                }
            }else{
                C[indexC] = smaller[indexB];
                indexB++;
                if(indexB == sizeB){
                    indexC++;
                    put(small,indexA,C,indexC);
                }
            }
            indexC++;
        }
    }

    /**
     * 将剩下的数据移动到另外一个数组
     * @param souce
     * @param indexA
     * @param C
     * @param indexC
     */
    private void put(int[] souce,int indexA, int[] C,int indexC){
        while(indexA < souce.length){
            C[indexC] = souce[indexA];
            indexA++;
            indexC++;
        }
    }










}

