package src.com.sid.recursionanddynamicprogramming.recursion.introductiontorecursion;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/introduction-to-recursion/factorial-official/ojquestion
 * Question
 * 1. You are given a number n.
 * 2. You are required to calculate the factorial of the number. Don't change the signature of factorial function.
 ***/
public class Factorial {
    public static void main(String[] args) throws Exception {
        int n = 5;
        System.out.println(factorial(n));
    }

    public static int factorial(int n) {
        if (n == 1) return n;
        return n * factorial(n - 1);
    }
}
