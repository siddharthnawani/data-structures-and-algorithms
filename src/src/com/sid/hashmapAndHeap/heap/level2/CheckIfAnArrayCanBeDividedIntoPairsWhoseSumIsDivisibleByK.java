package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/check-if-an-array-cab-be-divided-into-pairs-whose-sum-is-divisible-by-k-official/ojquestion#
 * <p>
 * Question
 * 1. You are given an array(arr) of integers and a number K.
 * 2. You have to find if the given array can be divided into pairs such that the sum of every pair is divisible by k.
 * <p>
 * Sample Input
 * 4
 * 9 7 5 3
 * 6
 * Sample Output
 * true
 ***/

/***
 * to handle negative numbers as well, the solution needs to be modified a little. Put  the below where-ever you are calculating remainder.
 * int rem = val % k;
 *  if(rem <0){
 *       rem +=k;
 *  }
 *
 * Logic behind this approach:
 *
 * lets take example of n =-1 and k=3
 *
 * all the probable solution pair for n could be :
 * -1,1
 * -1,4
 * -1,7
 * and so on..
 *
 * so remainder of 1,4,7.. is 1 and these numbers look for theeir equivalent partner with rem as 2 (k - rem) and to represent -1 as one of the choice for these we have to convert its remainder :
 *  -1 % 3 = -1.  to 2 i.e why we add k if the remainder is negative which is done by the code
 * if(rem <0){
 *       rem +=k;
 *  }
 *
 * Hope this helps..
 *
 *
 * **/
public class CheckIfAnArrayCanBeDividedIntoPairsWhoseSumIsDivisibleByK {

    public static void solution(int[] arr, int k) {
        HashMap<Integer, Integer> fmap = new HashMap<>();

        for (int val : arr) {
            int rem = val % k;
            if(rem <0){
                rem +=k;
            }
            int f = fmap.getOrDefault(rem, 0);
            fmap.put(rem, f + 1);
        }

        for (int val : arr) {
            int rem = val % k;
            if(rem <0){
                rem +=k;
            }

            if (rem == 0) {
                int f = fmap.get(rem);
                //It is an odd number
                if (f % 2 != 0) {
                    System.out.println(false);
                    return;
                }
            } else if (2 * rem == k) { // same as checking if rem = k/2
                int f = fmap.get(rem);
                //It is an odd number
                if (f % 2 != 0) {
                    System.out.println(false);
                    return;
                }
            } else {
                int f = fmap.get(rem);
                int remf = fmap.getOrDefault(k - rem, -1);
                if (f != remf) {
                    System.out.println(false);
                    return;
                }
            }


        }

        System.out.println(true);

    }

    public static void main(String[] args) {


        /*Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();*/
        //int[] arr = {-1,1,-2,2,-3,3,-4,4};
        int[] arr={1,2,3,4,5,6};
        int  k = 10;
        solution(arr, k);


    }
}
