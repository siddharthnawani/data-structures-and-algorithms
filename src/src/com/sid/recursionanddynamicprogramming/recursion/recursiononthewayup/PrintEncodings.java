package src.com.sid.recursionanddynamicprogramming.recursion.recursiononthewayup;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-encodings-official/ojquestion
 * <p>
 * Question
 * 1. You are given a string str of digits. (will never start with a 0)
 * 2. You are required to encode the str as per following rules
 * 1 -> a
 * 2 -> b
 * 3 -> c
 * ..
 * 25 -> y
 * 26 -> z
 * 3. Complete the body of printEncodings function - without changing signature -
 * to calculate and print all encodings of str.
 * Use the input-output below to get more understanding on what is required
 * 123 -> abc, aw, lc
 * 993 -> iic
 * 013 -> Invalid input. A string starting with 0 will not be passed.
 * 103 -> jc
 * 303 -> No output possible. But such a string maybe passed. In this case print nothing.
 * <p>
 * Sample Input
 * 655196
 * <p>
 * Sample Output
 * feeaif
 * feesf
 */
public class PrintEncodings {

    private void printEncodings(String str) {
        printEncodings(str, "");
    }

    private void printEncodings(String str, String anssofar) {
        //base case for length 0
        if (str.length() == 0) {
            System.out.println(anssofar);
            return;
        }
        //base case for length 1
        else if (str.length() == 1) {
            //check if its a zero
            char ch = str.charAt(0);
            if (ch == '0')
                return;
            else {
                char alphabet = getCharacterFromInteger(ch);
                System.out.println(anssofar + alphabet);
                return;
            }
        } else {//for length greater than and equal to 2 like : 123
            char ch = str.charAt(0);
            if (ch == '0')
                return;
            else {
                char alphabet1 = getCharacterFromInteger(ch);
                String ros = str.substring(1);
                printEncodings(ros, anssofar + alphabet1);

                // also recursively check for first two characters
                String ch12 = str.substring(0, 2);
                String roq = str.substring(2);

                int ch12v = Integer.parseInt(ch12);
                if (ch12v <= 26) {
                    char alphabet = (char) ('a' + ch12v - 1);
                    printEncodings(roq, anssofar + alphabet);
                }

            }

        }

    }

    //convert integer char to string and then convet it to char
    private char getCharacterFromInteger(char ch) {
        int chv = ch - '0';
        char alphabet = (char) ('a' + chv - 1);
        return alphabet;
    }

    public static void main(String[] args) {
        String str = "655196";
        new PrintEncodings().printEncodings(str);
    }
}
