package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/all-palindromic-partitions-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a string of length n.
 * 2. You have to partition the given string in such a way that every partition is a palindrome.
 * <p>
 * Sample Input
 * pep
 * Sample Output
 * (p) (e) (p)
 * (pep)
 */
public class AllPalindromicPartitions {

    private boolean isPalindrome(String str) {
        int si = 0;
        int ei = str.length() - 1;
        while (si < ei) {
            if (str.charAt(si) != str.charAt(ei))
                return false;
            si++;
            ei--;
        }
        return true;
    }

    private void solution(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String prefix = str.substring(0, i + 1);
            String ros = str.substring(i + 1);
            if (isPalindrome(prefix)) {
                solution(ros, asf + "(" + prefix + ") ");
            }
        }

    }

    public static void main(String[] args) {
        String str = "pep";
        new AllPalindromicPartitions().solution(str, "");
    }
}
