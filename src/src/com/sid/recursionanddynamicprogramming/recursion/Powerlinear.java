package src.com.sid.recursionanddynamicprogramming.recursion;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/introduction-to-recursion/power-linear-official/ojquestion
 * <p>
 * Question
 * 1. You are given a number x.
 * 2. You are given another number n.
 * 3. You are required to calculate x raised to the power n. Don't change the signature of power function .
 */
public class Powerlinear {
    public static void main(String[] args) throws Exception {
        int x = 2, n = 5;
        System.out.println(power(x, n));
    }

    public static int power(int x, int n) {
        if (n == 0) return 1;
        return x * power(x, n - 1);
    }
}
