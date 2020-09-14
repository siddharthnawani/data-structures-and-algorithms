package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/remove-invalid-parenthesis-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a string, which represents an expression having only opening and closing parenthesis.
 * 2. You have to remove minimum number of parenthesis to make the given expression valid.
 * 3. If there are multiple answers, you have to print all of them.
 * <p>
 * Sample Input
 * ()())()
 * Sample Output
 * (())()
 * ()()()
 */
public class RemoveInvalidParenthesis {

    private void solution(String str, int minRemovalLeft, HashSet<String> ans) {

        if (minRemovalLeft == 0) {
            //we have hit a valid string
            if (getMin(str) == 0) {
                if (!ans.contains(str)) {
                    ans.add(str);
                    System.out.println(str);
                }
            }
            return;
        }


        //remove each character till you hit the min removal left, and recursively check for other solutions
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i + 1);

            solution(left + right, minRemovalLeft - 1, ans);
        }
    }

    private int getMin(String str) {
        Stack<Character> st = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(')
                st.push(ch);
            else if (ch == ')') {
                if (st.size() == 0 || st.peek() == ')')
                    st.push(ch);
                else if (st.peek() == '(')
                    st.pop();
            }
        }
        return st.size();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        RemoveInvalidParenthesis ob = new RemoveInvalidParenthesis();
        ob.solution(str, ob.getMin(str), new HashSet<>());
    }
}
