package src.com.sid.recursionanddynamicprogramming.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Question
 * 1. You are given a number n and a number m representing number of rows and columns in a maze.
 * 2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
 * 3. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
 * Use sample input and output to take idea about output.
 * <p>
 * Sample Input
 * 3
 * 3
 * Sample Output
 * [hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]
 **/
public class GetMazePaths {


    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    private ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        if (sr == dr && sc == dc)
            return new ArrayList<>(Arrays.asList(""));


        ArrayList<String> hpaths = new ArrayList<>();
        ArrayList<String> vpaths = new ArrayList<>();

        if (sr < dr)//horizontal movement
            hpaths = getMazePaths(sr + 1, sc, dr, dc);
        if (sc < dc)//vertical movement
            vpaths = getMazePaths(sr, sc + 1, dr, dc);

        ArrayList<String> paths = new ArrayList<>();
        for (String path : hpaths)
            paths.add("h" + path);
        for (String path : vpaths)
            paths.add("v" + path);

        return paths;
    }

    public static void main(String[] args) {
        int r = 3, c = 3;
        System.out.println(new GetMazePaths().getMazePaths(1, 1, r, c));
    }

}
