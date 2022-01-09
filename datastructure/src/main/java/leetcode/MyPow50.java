package leetcode;

public class MyPow50 {


    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        boolean little = false;
        if (n < 0) {
            little = true;
            n = -n;
        }
        double count = count(x, n);
        return little?1 / count:count;

    }


    public static double count(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double result = count(x, n / 2);
        return (n % 2 == 0 ? result * result : result * result * x);
    }

    public static void main(String[] args) {
       // System.out.println(myPow(2.0d, 0));

        System.out.println(3>>1);
    }


}
