package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/abbreviation-suing-backtracking-official/ojquestion
 * <p>
 * Question
 * 1. You are given a word.
 * 2. You have to generate all abbrevations of that word.
 * <p>
 * Sample Input
 * pep
 * Sample Output
 * pep
 * pe1
 * p1p
 * p2
 * 1ep
 * 1e1
 * 2p
 * 3
 */
public class AbbreviationUsingBacktracking {

    private void solution(String str, String asf, int count, int pos) {

        if (pos == str.length()) {
            if (count == 0)
                System.out.println(asf);
            else
                System.out.println(asf + count);
            return;
        }

        //two cases : each element is either included or excluded

        //excluded case
        solution(str, asf, count + 1, pos + 1);

        //included case
        if (count == 0) {
            solution(str, asf + str.charAt(pos), count, pos + 1);
        } else {
            solution(str, asf + count + str.charAt(pos), 0, pos + 1);
        }

    }

    public static void main(String[] args) {
        String str = "pep";
        new AbbreviationUsingBacktracking().solution(str, "", 0, 0);
    }
}
