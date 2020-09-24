package src.com.sid.dynamicprogramming.IncludeExcludeStyle;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/arrange-buildings-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, which represents the length of a road. The road has n plots on it's each side.
 * 2. The road is to be so planned that there should not be consecutive buildings on either side of the road.
 * 3. You are required to find and print the number of ways in which the buildings can be built on both side of roads.
 * <p>
 * Sample Input
 * 6
 * Sample Output
 * 441
 **/
public class ArrangeBuildings {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long old0 = 1, old1 = 1;

        /**
         *This is same as Ciunt Binary String, just the catch is
         * for every solution on 1 side we have the same solution for
         * other side as well. Hence we are squaring the result.
         *
         **/


        for (int i = 2; i <= n; i++) {
            long new0 = old1;
            long new1 = old0 + old1;

            old0 = new0;
            old1 = new1;
        }

        long total = old0 + old1;
        System.out.println(total * total);
    }
}
