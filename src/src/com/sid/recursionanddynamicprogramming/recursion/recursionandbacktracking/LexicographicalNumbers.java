package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/lexicographical-numbers-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number.
 * 2. You have to print all the numbers from 1 to n in lexicographical order.
 * <p>
 * 14
 * Sample Output
 * 1
 * 10
 * 11
 * 12
 * 13
 * 14
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 ***/
public class LexicographicalNumbers {
    private void printLexiographically(int n) {
        for (int i = 1; i <= 9; i++) {
            dfs(i, n);
        }
    }

    private void dfs(int curr, int n) {
        if (curr > n)
            return;
        System.out.println(curr);
        for (int i = 0; i <= 9; i++) {
            dfs(curr * 10 + i, n);
        }
    }

    public static void main(String[] args) {
        int n = 14;
        new LexicographicalNumbers().printLexiographically(n);
    }
}
