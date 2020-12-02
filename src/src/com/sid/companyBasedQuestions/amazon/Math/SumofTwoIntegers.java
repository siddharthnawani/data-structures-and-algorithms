package src.com.sid.companyBasedQuestions.amazon.Math;

/**
 * https://leetcode.com/problems/sum-of-two-integers/
 * <p>
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * <p>
 * Example 1:
 * <p>
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 * <p>
 * Input: a = -2, b = 3
 * Output: 1
 ***/
public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        //since java automatically handles negative numbers

        while (b != 0) {
            int answer = a ^ b;
            int carry = (a & b) << 1;

            a = answer;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new SumofTwoIntegers().getSum(2, 3));
    }
}
