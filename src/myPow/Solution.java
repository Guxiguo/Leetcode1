package myPow;


/**
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 */
public class Solution {
    public static double myPow(double x, int n){
        double sum = 1;
        if(x==1.0){
            return x;
        }
        for (int i = 0; i < Math.abs(n) ; i++) {
            sum = sum * x;
        }
        if(n<0){
            sum = 1/sum;

        }
        return sum;
    }

    /**
     * public double myPow(double x, int n) {
     *         if (n == 0) return 1;
     *         if (n == 1) return x;
     *         if (n == -1) return 1 / x;
     *         double half = myPow(x, n / 2);
     *         double rest = myPow(x, n % 2);
     *         return rest * half * half;
     *     }
     */

    public static void main(String[] args) {
        double x = 2.1000;
        int n = 3;
        System.out.println(myPow(x,n));
    }
}
