package src.com.sid.dynamicprogramming.level2.subsequenceproblem;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/max-non-overlapping-bridges-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the number of bridges on a river.
 * 2. You are given n pair of numbers, representing the north bank and south bank co-ordinates of each bridge.
 * 3. You are required to print the count of maximum number of non-overlapping bridges.
 * <p>
 * Sample Input
 * 10
 * 10 20
 * 2 7
 * 8 15
 * 17 3
 * 21 40
 * 50 4
 * 41 57
 * 60 80
 * 80 90
 * 1 30
 * Sample Output
 * 7
 **/
public class MaximumNonoverlappingBridges {

    static class Bridge implements Comparable<Bridge> {
        int n;
        int s;

        Bridge(int n, int s) {
            this.n = n;
            this.s = s;
        }

        public int compareTo(Bridge o) {
            if (this.n != o.n)
                return this.n - o.n;
            else
                return this.s - o.s;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        Bridge[] bridgs = new Bridge[n];

        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            //String parts[]=line.split(" ");
            int np = Integer.parseInt(line.split(" ")[0]);
            int sp = Integer.parseInt(line.split(" ")[1]);
            bridgs[i] = new Bridge(np, sp);
        }

        /**
         *The idea is to sort the pridges wrt their north coordiante and
         * find th LIS of the douth point.
         *
         * the longest lis on south will give us the maximum non-
         * overlapping bridges
         *
         **/

        Arrays.sort(bridgs);

        int omax = 0;
        int[] lis = new int[n];

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (bridgs[j].s <= bridgs[i].s && lis[j] > max)
                    max = lis[j];
            }

            lis[i] = max + 1;

            if (lis[i] > omax)
                omax = lis[i];

        }

        System.out.println(omax);
    }
}
