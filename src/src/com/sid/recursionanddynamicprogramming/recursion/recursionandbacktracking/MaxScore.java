package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/max-score-official/ojquestion
 * <p>
 * Question
 * 1. You are given a list of words, a list of alphabets(might be repeating) and score of every alphabet
 * from a to z.
 * 2. You have to find the maximum score of any valid set of words formed by using the given
 * alphabets.
 * 3. A word can not be used more than one time.
 * 4. Each alphabet can be used only once.
 * 5. It is not necessary to use all the given alphabets.
 * <p>
 * Sample Input
 * 4
 * dog cat dad good
 * 9
 * a b c d d d g o o
 * 1 0 9 5 0 0 3 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0
 * Sample Output
 * 23
 * <p>
 * To run the program simply copy sample input to the console
 */
public class MaxScore {

    private int solution(String[] words, int[] farr, int[] score, int idx) {

        if (idx == words.length)
            return 0;
        //each word will either be part of final score or not

        //current word is excluded from final score
        int exclScore = solution(words, farr, score, idx + 1);

        //current word is included from final score
        int scoreofword = 0;
        String word = words[idx];
        boolean flag = true;// to ensure we are not breaching the frequency limits

        for (char c : word.toCharArray()) {
            if (farr[c - 'a'] == 0)
                flag = false;

            farr[c - 'a']--;
            scoreofword += score[c - 'a'];

        }
        int inclScore = 0;
        if (flag) {//if frequency permits then only make further call
            inclScore = scoreofword + solution(words, farr, score, idx + 1);
        }

        //backtracking - fix frequency to initial stage
        for (char c : word.toCharArray()) {
            farr[c - 'a']++;
        }

        return Math.max(exclScore, inclScore);

    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int nofWords = scn.nextInt();
        String[] words = new String[nofWords];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        int nofLetters = scn.nextInt();
        char[] letters = new char[nofLetters];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = scn.next().charAt(0);
        }
        int[] score = new int[26];
        for (int i = 0; i < score.length; i++) {
            score[i] = scn.nextInt();
        }
        if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
                || score.length == 0) {
            System.out.println(0);
            return;
        }
        int[] farr = new int[score.length];
        for (char ch : letters) {
            farr[ch - 'a']++;
        }
        System.out.println(new MaxScore().solution(words, farr, score, 0));


    }
}
