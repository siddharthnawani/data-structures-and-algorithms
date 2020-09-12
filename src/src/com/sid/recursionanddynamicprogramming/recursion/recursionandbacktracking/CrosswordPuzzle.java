package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/crossword-puzzle-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a 10*10 2-D array(arr) containing only '+' and '-' characters, which represents a
 * crossword puzzle.
 * 2. You are also given n number of words which need to be filled into the crossword.
 * 3. Cells containing '-' are to be filled with the given words.
 * <p>
 * Sample Input
 * +-++++++++
 * +-++++++++
 * +-++++++++
 * +-----++++
 * +-+++-++++
 * +-+++-++++
 * +++++-++++
 * ++------++
 * +++++-++++
 * +++++-++++
 * 4
 * LONDON
 * DELHI
 * ICELAND
 * ANKARA
 * Sample Output
 * +L++++++++
 * +O++++++++
 * +N++++++++
 * +DELHI++++
 * +O+++C++++
 * +N+++E++++
 * +++++L++++
 * ++ANKARA++
 * +++++N++++
 * +++++D++++
 */
public class CrosswordPuzzle {

    private void solution(char[][] arr, String[] words, int vidx) {
        if (vidx == words.length) {
            print(arr);
            return;
        }
        //write your code here
        int r = arr.length;
        int c = arr[0].length;

        String word = words[vidx];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {
                    if (canPlaceVertical(arr, word, i, j)) {
                        //this array will keep a track whether the character is inserted by use or it was present earlier
                        boolean[] visited = new boolean[word.length()];
                        placeVertical(arr, word, i, j, visited);
                        //explore other solutions
                        solution(arr, words, vidx + 1);

                        unplaceVertical(arr, word, i, j, visited);
                    }

                    if (canPlaceHorizontal(arr, word, i, j)) {
                        //this array will kee,p a track whether the character is inserted by use or it was present earlier
                        boolean[] visited = new boolean[word.length()];
                        placeHorizontal(arr, word, i, j, visited);
                        //explore other solutions
                        solution(arr, words, vidx + 1);

                        unplaceHorizontal(arr, word, i, j, visited);
                    }
                }
            }
        }


    }

    private boolean canPlaceVertical(char[][] arr, String word, int r, int c) {
        //it should either have + on both side or boundary
        int i = 0;
        for (; i < word.length(); i++) {

            if (r + i >= arr.length)
                return false;

            if (arr[r + i][c] == '-' || arr[r + i][c] == word.charAt(i))
                continue;
            else
                return false;
        }

        if (r + i == arr.length || arr[r + i][c] == '+')
            return true;
        else
            return false;

    }

    private boolean canPlaceHorizontal(char[][] arr, String word, int r, int c) {
        //it should either have + on both side or boundary
        int i = 0;
        for (; i < word.length(); i++) {

            if (c + i >= arr[0].length)
                return false;

            if (arr[r][c + i] == '-' || arr[r][c + i] == word.charAt(i))
                continue;
            else
                return false;
        }

        if (c + i == arr[0].length || arr[r][c + i] == '+')
            return true;
        else
            return false;

    }

    private void placeVertical(char[][] arr, String word, int r, int c, boolean[] visited) {
        for (int i = 0; i < word.length(); i++) {
            if (arr[r + i][c] == '-') {
                arr[r + i][c] = word.charAt(i);
                visited[i] = true;
            }
        }
    }

    private void placeHorizontal(char[][] arr, String word, int r, int c, boolean[] visited) {
        for (int i = 0; i < word.length(); i++) {
            if (arr[r][c + i] == '-') {
                arr[r][c + i] = word.charAt(i);
                visited[i] = true;
            }
        }
    }

    private void unplaceVertical(char[][] arr, String word, int r, int c, boolean[] visited) {
        for (int i = 0; i < word.length(); i++) {
            if (visited[i] == true) {
                arr[r + i][c] = '-';
            }
        }
    }

    private void unplaceHorizontal(char[][] arr, String word, int r, int c, boolean[] visited) {
        for (int i = 0; i < word.length(); i++) {
            if (visited[i] == true) {
                arr[r][c + i] = '-';
            }
        }
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        new CrosswordPuzzle().solution(arr, words, 0);
    }
}
