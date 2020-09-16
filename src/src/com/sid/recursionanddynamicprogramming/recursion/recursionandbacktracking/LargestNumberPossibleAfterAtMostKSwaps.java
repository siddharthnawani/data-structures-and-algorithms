package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/largest-number-at-most-k-swaps-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a string which represents digits of a number.
 * 2. You have to create the maximum number by performing at-most k swap operations on its digits.
 * <p>
 * Sample Input
 * 1234567
 * 4
 * Sample Output
 * 7654321
 */
public class LargestNumberPossibleAfterAtMostKSwaps {

    String max;

   private void findMaximum(String str, int k) {
        if (Integer.parseInt(str) > Integer.parseInt(max))
            max = str;

        if (k == 0) {
            return;
        }
        //traverse all options
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) < str.charAt(j)) {
                    str = swap(str, i, j);
                    findMaximum(str, k - 1);
                    str = swap(str, i, j);
                }

            }
        }

    }

    private String swap(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;

        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        String str = "1234567";
        int k = 4;
        LargestNumberPossibleAfterAtMostKSwaps obj=new LargestNumberPossibleAfterAtMostKSwaps();
        obj.max = str;
        obj.findMaximum(str, k);
        System.out.println(obj.max);
    }
}
