package src.com.sid.recursionanddynamicprogramming;

/***
 *
 * Given a positive integer n and 3 operations on n:
 *
 * n - 1
 * n / 2 (if n is even)
 * n / 3 (if n % 3 == 0)
 * Find the minimum number of above operations to reduce n to 1.
 *
 * Example 1:
 *
 * Input: n = 9
 * Output: 2
 * Explanation:
 * Step 1: 9 / 3 = 3
 * Step 2: 3 / 3 = 1
 * Example 2:
 *
 * Input: n = 8
 * Output: 3
 * Explanation:
 * Step 1: 8 / 2 = 4
 * Step 2: 4 / 2 = 2
 * Step 3: 2 - 1 = 1
 * Example 3:
 *
 * Input: n = 28
 * Output: 4
 *
 * https://leetcode.com/discuss/interview-question/538568/google-onsite-min-operations-to-reduce-number-to-1
 *
 *
 *
 * **/


public class MinOperationsToReduceNumberTo1 {
    private int countStepsViaRecursion(int n){
        if(n<=1) return 0;

        int minSteps=Integer.MAX_VALUE;
        int op1=countStepsViaRecursion(n-1);
        minSteps=op1;

        if(n%2==0){
            int op2=countStepsViaRecursion(n/2);
            minSteps=Math.min(op2,minSteps);
        }
        if(n%3==0){
            int op3=countStepsViaRecursion(n/3);
            minSteps=Math.min(op3,minSteps);
        }
        return 1+minSteps;
    }

    private int countStepsViaMemoization(int n,int[] memo){
        if(n<=1) return 0;

        if(memo[n]>0) return memo[n];

        int minSteps=Integer.MAX_VALUE;
        int op1=countStepsViaMemoization(n-1,memo);
        minSteps=op1;

        if(n%2==0){
            int op2=countStepsViaMemoization(n/2,memo);
            minSteps=Math.min(op2,minSteps);
        }
        if(n%3==0){
            int op3=countStepsViaMemoization(n/3,memo);
            minSteps=Math.min(op3,minSteps);
        }
        memo[n]= 1+minSteps;
        return memo[n];
    }
    private int countStepsViaTabulation(int n){
        int[] dp=new int[n+1];
        if(n==1) return 0;
        dp[1]=0;

        for(int i=2;i<=n;i++){

            int minSteps=dp[i-1];

            if(i%2==0)
                minSteps=Math.min(dp[i/2],minSteps);
            if(i%3==0)
                minSteps=Math.min(dp[i/3],minSteps);
            dp[i]=1+minSteps;
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int n=10;
        System.out.println(new MinOperationsToReduceNumberTo1().countStepsViaRecursion(n));
        int[] memo=new int[n+1];
        System.out.println(new MinOperationsToReduceNumberTo1().countStepsViaMemoization(n,memo));
        System.out.println(new MinOperationsToReduceNumberTo1().countStepsViaTabulation(n));
    }
}
