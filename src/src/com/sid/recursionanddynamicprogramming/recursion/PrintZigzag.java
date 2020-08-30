package src.com.sid.recursionanddynamicprogramming.recursion;

/****
 *
 * This question basically tells us about the Motion of recursion which could be heloful in creating
 * Euler's path.
 * So there are 5 paths/motions in recursions
 *
 * Pre
 * Left Call (LC)
 * In
 * Right Call (RC)
 * Post
 *
 * **************
 *
 * Question :
 *
 * 1. Here are a few sets of inputs and outputs for your reference
 * Input1 -> 1
 * Output1 -> 1 1 1
 *
 * Input2 -> 2
 * Output2 -> 2 1 1 1 2 1 1 1 2
 *
 * Input2 -> 3
 * Output3 -> 3 2 1 1 1 2 1 1 1 2 3 2 1 1 1 2 1 1 1 2 3
 *
 * 2. Figure out the pattern and complete the recursive function pzz to achieve the above for any positive number n.
 *
 * I/P
 *
 * 2
 *
 * O/p :
 *
 * Pre 2
 * Pre 1
 * In 1
 * Post 1
 * In 2
 * Pre 1
 * In 1
 * Post 1
 * Post 2
 * ***/
public class PrintZigzag {
    public static void pzz(int n) {
        if (n == 0)
            return;
        System.out.println("Pre " + n);//Everything from this line UP is Pre Area
        pzz(n - 1); // LC
        System.out.println("In " + n); //In
        pzz(n - 1); // RC
        System.out.println("Post " + n); //Everything including this is Post Area
    }

    public static void main(String[] args) {
        int n = 2;
        pzz(n);
    }

}
