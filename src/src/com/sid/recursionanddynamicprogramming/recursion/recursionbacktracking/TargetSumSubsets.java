package src.com.sid.recursionanddynamicprogramming.recursion.recursionbacktracking;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/recursion-backtracking/target-sum-subsets-official/ojquestion
 * <p>
 * Question
 * 1. You are given a number n, representing the count of elements.
 * 2. You are given n numbers.
 * 3. You are given a number "tar".
 * 4. Complete the body of printTargetSumSubsets function - without changing signature - to calculate and print all subsets of given elements, the contents of which sum to "tar". Use sample input and output to get more idea.
 * <p>
 * Sample Input
 * 5
 * 10
 * 20
 * 30
 * 40
 * 50
 * 60
 * <p>
 * Sample Output
 * 10, 20, 30, .
 * 10, 50, .
 * 20, 40, .
 ***/
public class TargetSumSubsets {

    // set is the subset
    // sos is sum of subset
    // tar is target
    private void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        if (idx == arr.length) {
            if (sos == tar)
                System.out.println(set);
            return;
        }

        //each element has 2 options either include or not
        printTargetSumSubsets(arr, idx + 1, set + arr[idx] + ", ", sos + arr[idx], tar);
        printTargetSumSubsets(arr, idx + 1, set, sos, tar);

    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {
                10,
                20,
                30,
                40,
                50
        };
        int tar = 60;
        new TargetSumSubsets().printTargetSumSubsets(arr, 0, "", 0, tar);
    }
}
