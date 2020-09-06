package src.com.sid.recursionanddynamicprogramming.recursion.recursiononthewayup;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-maze-paths-official/ojquestion
 * <p>
 * Question
 * 1. You are given a number n and a number m representing number of rows and columns in a maze.
 * 2. You are standing in the top-left corner and have to reach the bottom-right corner.
 * Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
 * 3. Complete the body of pri tMazePath function - without changing signature - to print the list of all paths that can be used to move from top-left to bottom-right.
 * Use sample input and output to take idea about output.
 * <p>
 * Sample Input
 * 2
 * 2
 * Sample Output
 * hv
 * vh
 **/
public class PrintMazePaths {

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    private void printMazePaths(int sr, int sc, int dr, int dc, String pathsofar) {
        if (sr > dr || sc > dc)
            return;
        if (sr == dr && sc == dc) {
            System.out.println(pathsofar);
            return;
        }
        printMazePaths(sr, sc + 1, dr, dc, pathsofar + "h ");
        printMazePaths(sr + 1, sc, dr, dc, pathsofar + "v ");
    }

    public static void main(String[] args) {
        int dr = 2, dc = 2;
        new PrintMazePaths().printMazePaths(1, 1, dr, dc, "");
    }
}
