package src.com.sid.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: ["()"]
 **/
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, String cur_string, int open, int close, int max) {
        if (cur_string.length() == max * 2) {
            res.add(cur_string);
            return;
        }

        //ensure open is less than max
        if (open < max) backtrack(res, cur_string + "(", open + 1, close, max);
        //close is less than open
        if (close < open) backtrack(res, cur_string + ")", open, close + 1, max);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new GenerateParentheses().generateParenthesis(n));
    }
}
