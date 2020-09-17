package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking.permutationsandcombinations;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/combinations-i-official/ojquestion#
 * <p>
 * Question
 * 1. You are give a number of boxes (nboxes) and number of identical items (ritems).
 * 2. You are required to place the items in those boxes and print all such configurations possible.
 * <p>
 * Items are identical and all of them are named 'i'.
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
public class Combinations1 {

    private void combinations(int cb, int tb, int ssf, int ts, String asf) {
        if (cb > tb) {
            if (ssf == ts) {
                System.out.println(asf);
            }
            return;
        }
        
        //two choices for each box, either include or exclude
        //include
        combinations(cb + 1, tb, ssf + 1, ts, asf + "i");
        //exclude
        combinations(cb + 1, tb, ssf, ts, asf + "-");
    }

    public static void main(String[] args) throws Exception {

        int nboxes = 5;
        int ritems = 3;
        new Combinations1().combinations(1, nboxes, 0, ritems, "");
    }
}
