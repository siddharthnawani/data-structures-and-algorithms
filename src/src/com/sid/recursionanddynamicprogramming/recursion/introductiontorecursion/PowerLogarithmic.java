package src.com.sid.recursionanddynamicprogramming.recursion.introductiontorecursion;

/***
 *https://www.pepcoding.com/resources/online-java-foundation/introduction-to-recursion/power-logarithmic-official/ojquestion
 *
 * Question
 * 1. You are given a number x.
 * 2. You are given another number n.
 * 3. You are required to calculate x raised to the power n. Don't change the signature of power function.
 *
 * ***/
public class PowerLogarithmic {
    public static void main(String[] args) throws Exception {
        int x = 2, n = 5;
        System.out.println(power(x, n));
    }

    public static int power(int x, int n) {
        if (n == 0) return 1;
        int xnb2 = power(x, n / 2);
        int xn = xnb2 * xnb2;
        if (n % 2 == 1)
            xn *= x;
        return xn;
    }
}
