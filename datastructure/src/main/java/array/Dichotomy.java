package array;

/**
 * 二分法
 */
public class Dichotomy {
    long[] values = new long[]{1,2,3,45,67,89};
    long find(long searchkey){
        int lowerindex = 0;
        int highindex = values.length-1;
        int curindex;
        while(true){
            curindex = (lowerindex+highindex) >>> 1;

            if(values[curindex] > searchkey){
                highindex = curindex-1;
            }else if(values[curindex] <searchkey){
                lowerindex = curindex+1;
            }else{
                return values[curindex];
            }

        }

    }

    public static void main(String[] args) {
        Dichotomy dichotomy = new Dichotomy();
        dichotomy.find(2);

    }



}
