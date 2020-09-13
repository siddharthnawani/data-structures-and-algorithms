package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/friends-pairing-2-official/ojquestion
 * <p>
 * Question
 * 1. You are given an integer n, which represents n friends numbered from 1 to n.
 * 2. Each one can remain single or can pair up with some other friend.
 * 3. You have to print all the configurations in which friends can remain single or can be paired up.
 * <p>
 * Sample Input
 * 3
 * Sample Output
 * 1.(1) (2) (3)
 * 2.(1) (2,3)
 * 3.(1,2) (3)
 * 4.(1,3) (2)
 */
public class FriendsPairing2 {
    int counter = 1;

    private void solution(int i, int n, boolean[] used, String asf) {
        if (i > n) {
            System.out.println(counter + "." + asf);
            counter++;
            return;
        }

        if (used[i]) {
            solution(i + 1, n, used, asf);
        } else {
            used[i] = true;
            solution(i + 1, n, used, asf + "(" + i + ") ");

            for (int j = i + 1; j <= n; j++) {
                if (used[j] == false) {
                    used[j] = true;
                    solution(i + 1, n, used, asf + "(" + i + "," + j + ") ");
                    used[j] = false;
                }
            }

            used[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] used = new boolean[n + 1];
        new FriendsPairing2().solution(1, n, used, "");
    }
}
