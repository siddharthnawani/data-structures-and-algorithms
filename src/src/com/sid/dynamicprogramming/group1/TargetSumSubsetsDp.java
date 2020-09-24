package src.com.sid.dynamicprogramming.group1;


import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/target-sum-subsets-dp-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the count of elements.
 * 2. You are given n numbers.
 * 3. You are given a number "tar".
 * 4. You are required to calculate and print true or false, if there is a subset the elements of which add
 * up to "tar" or not.
 * <p>
 * Sample Input
 * 5
 * 4
 * 2
 * 7
 * 1
 * 3
 * 10
 * Sample Output
 * true
 */
public class TargetSumSubsetsDp {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        int tar = in.nextInt();

        /**
         * dp array where row : 1 more than array size, since we are
         * also considering blank element
         *
         * column : 0 to target
         *
         * Insight :
         *
         * Here duplicacy is not allwed hence the 2d array else, there would be 1 d array.
         *
         * */
        boolean[][] dp = new boolean[arr.length + 1][tar + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                //first element will be true as empty element can make 0
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                }//0 can be made by all subsets by not including anyone
                else if (j == 0) {
                    dp[i][j] = true;
                }//nothing can be made from blank subset except 0
                else if (i == 0) {
                    dp[i][j] = false;
                } else {

                    //there are two options either include the element or nit

                    //if previous elements can make the current sum, then put true
                    if (dp[i - 1][j] == true) {
                        dp[i][j] = true;
                    }//check whether with this elemet the remaining target can be achieved by the previous elements
                    else {
                        //i-1 because, arr[i-1] is mapped to i th element in dp row
                        int val = arr[i - 1];

                        //j is the sum that needs to reached; hence current element should be atleast bigger than else remaning sum will be negaive
                        if (j >= val) {
                            if (dp[i - 1][j - val]) {
                                dp[i][j] = true;
                            }
                        }
                    }


                }


            }
        }

        System.out.println(dp[n][tar]);

    }
}
