package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking.permutationsandcombinations;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/permutations-ii-official/ojquestion#
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
 * 13200
 * 13020
 * 13002
 * ....
 * ....
 */
public class Permutations2 {

    public static void main(String[] args) {
        int boxes = 5;
        int items = 3;

        new Permutations2().permutations(1, boxes, new int[items], 0, items, "");
    }

    private void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf) {

        //if we have explored all the boxes
        if (cb > tb) {
            if (ssf == ts) {
                System.out.println(asf);
            }

            return;
        }

        //there are options equal to no of items + 1 , the last 1 denotes the option of empty at current level
        for (int i = 0; i < items.length; i++) {
            //if current item is not used
            if (items[i] == 0) {
                //block the place
                items[i] = cb;
                permutations(cb + 1, tb, items, ssf + 1, ts, asf + (i + 1));
                //release the place
                items[i] = 0;

            }
        }

        //the last option where we explore the option of not using any place at this level
        permutations(cb + 1, tb, items, ssf, ts, asf + 0);
    }
}
