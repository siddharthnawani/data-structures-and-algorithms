package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking.permutationsandcombinations;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/combinations-2-official/ojquestion#
 * <p>
 * Question
 * 1. You are give a number of boxes (nboxes) and number of identical items (ritems).
 * 2. You are required to place the items in those boxes and print all such configurations possible.
 * <p>
 * Sample Input
 * 5
 * 3
 * Sample Output
 * iii--
 * ii-i-
 * ii--i
 * i-ii-
 * i-i-i
 * i--ii
 * -iii-
 * -ii-i
 * -i-ii
 * --iii
 */
public class Combinations2 {
    private void combinations(boolean[] boxes, int ci, int ti, int lb) {
        if (ci > ti) {
            for (int b = 0; b < boxes.length; b++) {
                if (boxes[b])
                    System.out.print("i");
                else
                    System.out.print("-");
            }
            System.out.println();
            return;
        }


        for (int b = lb + 1; b < boxes.length; b++) {
            if (boxes[b] == false) {
                boxes[b] = true;
                combinations(boxes, ci + 1, ti, b);
                boxes[b] = false;
            }
        }


    }

    public static void main(String[] args) throws Exception {
        int nboxes = 5;
        int ritems = 3;
        new Combinations2().combinations(new boolean[nboxes], 1, ritems, -1);
    }
}
