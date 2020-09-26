package src.com.sid.dynamicprogramming.IncludeExcludeStyle;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint-fence-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n and a number k in separate lines, representing the number of fences and number of colors.
 * 2. You are required to calculate and print the number of ways in which the fences could be painted so that not more than two fences have same colors.
 * <p>
 * Sample Input
 * 8
 * 3
 * Sample Output
 * 3672
 **/
public class PaintFence {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        /**
         *The idea is to maintain dp of two thins along with their total
         *
         * same- items upto i where the last two fences have same color
         *
         * diff- items upto i where the last two fences have diff colors
         *
         * totalis their total
         **/
        long same = k * 1;
        long diff = k * (k - 1);
        long total = same + diff;

        for (int i = 3; i <= n; i++) {
            same = diff;
            diff = total * (k - 1);

            total = same + diff;
        }

        System.out.println(total);
    }
}
