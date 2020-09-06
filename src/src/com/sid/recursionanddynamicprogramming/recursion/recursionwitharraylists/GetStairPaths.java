package src.com.sid.recursionanddynamicprogramming.recursion.recursionwitharraylists;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Question
 * 1. You are given a number n representing number of stairs in a staircase.
 * 2. You are standing at the bottom of staircase. You are allowed to climb 1 step,
 * 2 steps or 3 steps in one move.
 * 3. Complete the body of getStairPaths function - without changing signature -
 * to get the list of all paths that can be used to climb the staircase up.
 * Use sample input and output to take idea about output.
 * <p>
 * <p>
 * Sample Input
 * 3
 * Sample Output
 * [111, 12, 21, 3]
 **/
public class GetStairPaths {
    private ArrayList<String> getStairPaths(int n) {
        /**Base case :
         * going fom 0 -> 0 is also a path
         * for negative there is no  path
         * */
        if (n == 0)
            return new ArrayList<String>(Arrays.asList(""));
        else if (n < 0)
            return new ArrayList<>();
        /**
         * This is our faith
         * ***/
        //all paths with 1 step
        ArrayList<String> paths1 = getStairPaths(n - 1);
        //all paths with 2 step
        ArrayList<String> paths2 = getStairPaths(n - 2);
        //all paths with 3 step
        ArrayList<String> paths3 = getStairPaths(n - 3);

        /**
         * Meet faith with expectations
         * **/
        ArrayList<String> mres = new ArrayList<>();

        //Add 1 in front, since these all are 1 step paths
        for (String path : paths1)
            mres.add(1 + path);
        //Add 2 in front, since these all are 2 step paths
        for (String path : paths2)
            mres.add(2 + path);
        //Add 3 in front, since these all are 3 step paths
        for (String path : paths3)
            mres.add(3 + path);

        return mres;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new GetStairPaths().getStairPaths(n));

    }
}
