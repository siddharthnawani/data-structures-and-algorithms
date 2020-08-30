package src.com.sid.recursionanddynamicprogramming.recursion;

/***
 *
 * https://www.pepcoding.com/resources/online-java-foundation/introduction-to-recursion/print-increasing-decreasing-official/ojquestion#
 * 1. You are given a positive number n.
 * 2. You are required to print the counting from n to 1 and back to n again.
 * 3. You are required to not use any loops. Complete the body of pdi function to achieve it.
 * Don't change the signature of the function.
 *
 * **/
public class PrintIncreasingDecreasing {
    public static void main(String[] args) throws Exception {
        int n = 3;
        pdi(n);
    }

    public static void pdi(int n) {
        if (n == 0) return;
        System.out.println(n);
        pdi(n - 1);
        System.out.println(n);
    }
}
