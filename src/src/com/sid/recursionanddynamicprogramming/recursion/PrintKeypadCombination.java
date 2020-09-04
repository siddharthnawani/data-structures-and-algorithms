package src.com.sid.recursionanddynamicprogramming.recursion;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-kpc-official/ojquestion
 * <p>
 * <p>
 * Question
 * 1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
 * 2. The following list is the key to characters map
 * 0 -> .;
 * 1 -> abc
 * 2 -> def
 * 3 -> ghi
 * 4 -> jkl
 * 5 -> mno
 * 6 -> pqrs
 * 7 -> tu
 * 8 -> vwx
 * 9 -> yz
 * 3. Complete the body of printKPC function - without changing signature - to print the list of all words that could be produced by the keys in str.
 * Use sample input and output to take idea about output.
 * <p>
 * Sample Input
 * 78
 * Sample Output
 * tv
 * tw
 * tx
 * uv
 * uw
 * ux
 ***/
public class PrintKeypadCombination {
    private final String[] codes = {
            ".;",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tu",
            "vwx",
            "yz"};

    private void printKPC(String str) {
        printKPC(str, "");
    }

    private void printKPC(String str, String ans) {

        /**
         *base case return when there are no further characters left
         * **/
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);

        /**fetch all characters of keypad and recursively solve for each
         * */
        String codeforch = codes[ch - '0'];
        for (char code : codeforch.toCharArray()) {
            printKPC(ros, ans + code);
        }

    }

    public static void main(String[] args) {
        String str = "78";
        new PrintKeypadCombination().printKPC(str);
    }
}
