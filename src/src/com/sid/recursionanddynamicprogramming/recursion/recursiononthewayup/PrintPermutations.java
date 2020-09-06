package src.com.sid.recursionanddynamicprogramming.recursion.recursiononthewayup;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-permutations-official/ojquestion
 * <p>
 * Question
 * 1. You are given a string str.
 * 2. Complete the body of printPermutations function - without changing signature -
 * to calculate and print all permutations of str.
 * Use sample input and output to take idea about permutations.
 * <p>
 * Sample Input
 * abc
 * Sample Output
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 */
public class PrintPermutations {
    private void printPermutations(String str) {
        printPermutations(str, "");
    }

    private void printPermutations(String str, String pathsofar) {

        if (str.length() == 0) {
            System.out.println(pathsofar);
            return;
        }
        /**Iterate all char
         * */
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String lpart = str.substring(0, i);
            String rpart = str.substring(i + 1);
            String roq = lpart + rpart;
            printPermutations(roq, pathsofar + ch);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        new PrintPermutations().printPermutations(str);
    }

}
