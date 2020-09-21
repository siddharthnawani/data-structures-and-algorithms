package src.com.sid.dynamicprogramming;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/fibonacci-dp-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n.
 * 2. You are required to print the nth element of fibonnaci sequence.
 * <p>
 * Sample Input
 * 10
 * Sample Output
 * 55
 */
public class Fibonaccidp {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Fibonaccidp ob = new Fibonaccidp();
        System.out.println(ob.fib(n, new int[n + 1]));
    }

    private int fib(int n, int[] qb) {
        if (n == 0 || n == 1) return n;

        if (qb[n] != 0) return qb[n];

        int fibnm1 = fib(n - 1, qb);
        int fibnm2 = fib(n - 2, qb);

        qb[n] = fibnm1 + fibnm2;
        return qb[n];

    }
}
