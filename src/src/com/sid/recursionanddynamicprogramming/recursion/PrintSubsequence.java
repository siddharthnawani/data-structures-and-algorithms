package src.com.sid.recursionanddynamicprogramming.recursion;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-subsequence-official/ojquestion
 * <p>
 * Question
 * 1. You are given a string str.
 * 2. Complete the body of printSS function - without changing signature -
 * to calculate and print all subsequences of str.
 * Use sample input and output to take idea about subsequences.
 * <p>
 * Sample Input
 * yvTA
 * <p>
 * Sample Output
 * yvTA
 * yvT
 * yvA
 * yv
 * yTA
 * yT
 * yA
 * y
 * vTA
 * vT
 * vA
 * v
 * TA
 * T
 * A
 **/
public class PrintSubsequence {

    private void printSS(String str) {
        printSS(str, "");
    }

    private void printSS(String str, String ans) {

        /**
         * Stop when there are no more characters in input string
         * **/
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        char fchar = str.charAt(0);
        String ros = str.substring(1);

        /**
         * Always there will be two options, either include a character or not
         * **/
        printSS(ros, ans + "");
        printSS(ros, ans + fchar);

    }

    public static void main(String[] args) {
        String str = "yvTA";
        new PrintSubsequence().printSS(str);

    }
}
