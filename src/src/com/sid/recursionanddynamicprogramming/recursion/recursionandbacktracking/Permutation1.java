package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/permutation-i-official/ojquestion#
 * <p>
 * Question
 * 1. You are give a number of boxes (nboxes) and number of non-identical items (ritems).
 * 2. You are required to place the items in those boxes and print all such configurations possible.
 * <p>
 * Sample Input
 * 5
 * 3
 * Sample Output
 * 12300
 * 12030
 * 12003
 * ...
 * ....
 */
public class Permutation1 {

    private void permutations(int[] boxes, int ci, int ti) {
        if (ci > ti) {

            for (int i = 0; i < boxes.length; i++)
                System.out.print(boxes[i]);

            System.out.println();
            return;
        }

        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = ci;
                permutations(boxes, ci + 1, ti);
                boxes[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int nboxes = 5;
        int ritems = 3;
        new Permutation1().permutations(new int[nboxes], 1, ritems);
    }
}
