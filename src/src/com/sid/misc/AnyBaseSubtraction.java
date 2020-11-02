package src.com.sid.misc;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/function-and-arrays/any-base-subtraction-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a base b.
 * 2. You are given two numbers n1 and n2 of base b.
 * 3. You are required to subtract n1 from n2 and print the value.
 * <p>
 * Sample Input
 * 8
 * 1
 * 100
 * Sample Output
 * 77
 **/
public class AnyBaseSubtraction {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getDifference(b, n1, n2);
        System.out.println(d);
    }

    public static int getDifference(int b, int n1, int n2) {

        int rv = 0;
        int c = 0;
        int p = 1;
        while (n2 > 0) {

            int d1 = n1 % 10;
            n1 = n1 / 10;
            int d2 = n2 % 10;
            n2 = n2 / 10;

            int d = 0;
            d2 = d2 + c;

            if (d2 >= d1) {
                c = 0;
                d = d2 - d1;
            } else {
                c = -1;
                d = d2 + b - d1;
            }

            rv += d * p;
            p = p * 10;


        }

        return rv;

    }
}
