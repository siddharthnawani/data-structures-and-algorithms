package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/k-partitions-official/ojquestion#
 * <p>
 * Question
 * 1. You are given two integers n and k, where n represents number of elements and k represents
 * number of subsets.
 * 2. You have to partition n elements in k subsets and print all such configurations.
 * <p>
 * Sample Input
 * 3
 * 2
 * Sample Output
 * 1. [1, 2] [3]
 * 2. [1, 3] [2]
 * 3. [1] [2, 3]
 */
public class Kpartitions {
    private int counter = 1;

    private void solution(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
        if (i > n) {
            if (rssf == k) {
                System.out.print(counter + ". ");
                counter++;
                for (ArrayList<Integer> a : ans) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
            return;
        }


        //Traverse all the available arraylist and start exploring options
        for (int j = 0; j < ans.size(); j++) {
            //there can be 2 options
            //Pair with an existing set
            //start your new set

            if (ans.get(j).size() > 0) {
                ans.get(j).add(i);
                solution(i + 1, n, k, rssf, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
            } else {//creating a new set but do it only once
                ans.get(j).add(i);
                solution(i + 1, n, k, rssf + 1, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
                break;

            }
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        new Kpartitions().solution(1, n, k, 0, ans);

    }
}
