package digui;

/**
 * 斐波拉起数列
 */
public class Fblq {


    public static void main(String[] args) {
        //1+2+3+4+5+6

        System.out.println(count(49));


    }

    public static long count(int n){
        if(n == 0 || n == 1){
            return 1;
        }
       return  (count(n-1)+count(n-2));
    }

}
