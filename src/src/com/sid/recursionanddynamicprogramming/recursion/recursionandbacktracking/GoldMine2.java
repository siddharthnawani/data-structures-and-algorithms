package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking;

import java.util.ArrayList;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/gold-mine-2-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the number of rows.
 * 2. You are given a number m, representing the number of columns.
 * 3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
 * 4. You are allowed to take one step left, right, up or down from your current position.
 * 5. You can't visit a cell with 0 gold and the same cell more than once.
 * 6. Each cell has a value that is the amount of gold available in the cell.
 * 7. You are required to identify the maximum amount of gold that can be dug out from the mine if
 * you start and stop collecting gold from any position in the grid that has some gold.
 * <p>
 * Sample Input
 * 6
 * 6
 * 0 1 4 2 8 2
 * 4 3 6 5 0 4
 * 1 2 4 1 4 6
 * 2 0 7 3 2 2
 * 3 1 5 9 2 4
 * 2 7 0 8 5 1
 * Sample Output
 * 120
 */
public class GoldMine2 {

    static int max = 0;

    private void travelAndCollectGold(int[][] arr, int i, int j, boolean[][] visited, ArrayList<Integer> bag) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length ||
                arr[i][j] == 0 || visited[i][j] == true) {
            return;
        }

        visited[i][j] = true;
        bag.add(arr[i][j]);
        travelAndCollectGold(arr, i - 1, j, visited, bag);
        travelAndCollectGold(arr, i, j + 1, visited, bag);
        travelAndCollectGold(arr, i, j - 1, visited, bag);
        travelAndCollectGold(arr, i + 1, j, visited, bag);
    }

    private void getMaxGold(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0 && visited[i][j] == false) {
                    ArrayList<Integer> bag = new ArrayList<>();
                    travelAndCollectGold(arr, i, j, visited, bag);

                    int sum = 0;
                    for (int val : bag) {
                        sum += val;
                    }
                    max = Math.max(max, sum);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 4, 2, 8, 2},
                {4, 3, 6, 5, 0, 4},
                {1, 2, 4, 1, 4, 6},
                {2, 0, 7, 3, 2, 2},
                {3, 1, 5, 9, 2, 4},
                {2, 7, 0, 8, 5, 1}
        };
        new GoldMine2().getMaxGold(arr);
        System.out.println(max);
    }
}
