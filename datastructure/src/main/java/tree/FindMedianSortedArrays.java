package tree;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums2 = new int[]{2};
        int[] nums1 = new int[]{1,3};
        System.out.println(findMedianSortedArraysm( nums1, nums2));
    }

    /**
     * 先找出
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArraysm(int[] nums1, int[] nums2) {
        int sum = nums2.length+nums1.length;
        // 判断基数偶数
        int midr = sum/2;
        int midl = -1;
        if(sum/2==0){
            midl = midr-1;
        }
        int i=0;
        int j=0;
        int ij = 0;
        int[] index = new int[2];
        while (i<nums1.length || j<nums2.length){
            ij = j+i;
            if(midl != -1 && (ij) == midl){
                index[0] = nums1[i]>nums2[j]?nums1[i]:nums2[j];
            }
            if((ij) == midr){
                index[1] = nums1[i]>nums2[j]?nums1[i]:nums2[j];
                break;
            }
            if(nums1[i]<nums2[j] && nums1[i+1]<nums2[j]){
                if(i<nums1.length ){
                    i++;
                }else{
                    j++;
                }
            }else if( nums2[j+1]<nums1[i]){
                if(j<nums2.length ){
                    j++;
                }else{
                    i++;
                }
            }

        }
        return (index[0]+ index[1])/2;

    }
}
