package src.com.sid.recursionanddynamicprogramming.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Question
 * 1. You are given a number n and a number m representing number of rows and columns in a maze.
 * 2. You are standing in the top-left corner and have to reach the bottom-right corner.
 * 3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..).
 * 4. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
 * Use sample input and output to take idea about output.
 * <p>
 * <p>
 * Sample Input
 * 2
 * 2
 * Sample Output
 * [h1v1, v1h1, d1]
 **/
public class GetMazePathWithJumps {
    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    private ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        //Base case
        if (sr == dr && sc == dc)
            return new ArrayList<>(Arrays.asList(""));
        ArrayList<String> paths = new ArrayList<>();

        //horizontal movement
        for (int ms = 1; ms <= dc - sc; ms++) {
            ArrayList<String> hpaths = getMazePaths(sr, sc + ms, dr, dc);
            for (String path : hpaths)
                paths.add("h" + ms + path);
        }
        //vertical movement
        for (int ms = 1; ms <= dr - sr; ms++) {
            ArrayList<String> vptahs = getMazePaths(sr + ms, sc, dr, dc);
            for (String path : vptahs)
                paths.add("v" + ms + path);
        }
        //diagonal movement
        for (int ms = 1; ms <= dr - sr && ms <= dc - sc; ms++) {
            ArrayList<String> dptahs = getMazePaths(sr + ms, sc + ms, dr, dc);
            for (String path : dptahs)
                paths.add("d" + ms + path);
        }

        return paths;
    }

    public static void main(String[] args) {
        int dr = 2, dc = 2;
        System.out.println(new GetMazePathWithJumps().getMazePaths(1, 1, dr, dc));
    }
}
