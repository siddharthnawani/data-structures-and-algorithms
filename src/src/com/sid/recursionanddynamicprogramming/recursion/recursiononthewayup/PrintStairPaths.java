package src.com.sid.recursionanddynamicprogramming.recursion.recursiononthewayup;

/***
 * https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-stair-paths-official/ojquestion
 *
 * Question
 * 1. You are given a number n representing number of stairs in a staircase.
 * 2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
 * 3. Complete the body of printStairPaths function - without changing signature - to print the list of all paths that can be used to climb the staircase up.
 * Use sample input and output to take idea about output.
 *
 * Sample Input
 * 3
 * Sample Output
 * 111
 * 12
 * 21
 * 3
 *
 * **/
public class PrintStairPaths {

    private void printStairPaths(int n, String path) {
        if (n < 0)
            return;
        if (n == 0) {
            System.out.println(path);
            return;
        }

        printStairPaths(n - 1, path + "1");
        printStairPaths(n - 2, path + "2");
        printStairPaths(n - 3, path + "3");
    }

    public static void main(String[] args) {
        int n = 3;
        new PrintStairPaths().printStairPaths(n, "");
    }
}
