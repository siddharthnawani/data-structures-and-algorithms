package src.com.sid.recursionanddynamicprogramming.recursion.introductiontorecursion;

/***
 *
 * https://www.youtube.com/watch?v=Y5IobAWmfjQ&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=2
 *
 * Print Increasing numbers using recursion
 *
 * **/
public class PrintIncreasing {
    private void printIncresing(int n){
        /**
         * Code which is written above always gets executed when recursion is going up to the stack ie
         * when recursive calls are being submitted
         * **/
        if(n==0) return;
        printIncresing(n-1);
        /***
         * Code written after the recursive call gets executed when the recursion is coming down from
         * thw stack.
         * **/
        System.out.println(n);
    }

    public static void main(String[] args) {
        int n=5;
        new PrintIncreasing().printIncresing(n);
    }

}
