package src.com.sid.companyBasedQuestions.amazon.TreesAndGraphs;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/cut-off-trees-for-golf-event/
 * 675. Cut Off Trees for Golf Event
 * You are asked to cut off all the trees in a forest for a golf event. The forest is represented as an m x n matrix. In this matrix:
 * <p>
 * 0 means the cell cannot be walked through.
 * 1 represents an empty cell that can be walked through.
 * A number greater than 1 represents a tree in a cell that can be walked through, and this number is the tree's height.
 * In one step, you can walk in any of the four directions: north, east, south, and west. If you are standing in a cell with a tree, you can choose whether to cut it off.
 * <p>
 * You must cut off the trees in order from shortest to tallest. When you cut off a tree, the value at its cell becomes 1 (an empty cell).
 * <p>
 * Starting from the point (0, 0), return the minimum steps you need to walk to cut off all the trees. If you cannot cut off all the trees, return -1.
 * <p>
 * You are guaranteed that no two trees have the same height, and there is at least one tree needs to be cut off.
 * Input: forest = [[1,2,3],[0,0,4],[7,6,5]]
 * Output: 6
 * Explanation: Following the path above allows you to cut off the trees from shortest to tallest in 6 steps.
 *
 * Ref: https://leetcode.com/problems/cut-off-trees-for-golf-event/discuss/107404/Java-solution-PriorityQueue-%2B-BFS
 */
public class CutOffTreesforGolfEvent {
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) return 0;
        int m = forest.size(), n = forest.get(0).size();

        //pripority queue to sort on the basis of height of tress
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1)
                    pq.add(new int[]{i, j, forest.get(i).get(j)});
            }
        }

        int[] start = new int[]{0, 0};
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] tree = pq.poll();
            int step = minStep(forest, start, tree); // forest, start pos, end pos
            if (step < 0) return -1;

            sum += step;

            //update start pos
            start[0] = tree[0];
            start[1] = tree[1];
        }

        return sum;

    }

    //this is basoally bfs
    private int minStep(List<List<Integer>> forest, int[] start, int[] tree) {
        int step = 0;
        int m = forest.size(), n = forest.get(0).size();
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == tree[0] && curr[1] == tree[1]) return step;

                for (int[] d : dir) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n
                            || forest.get(nr).get(nc) == 0 || visited[nr][nc]) continue;
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }

            }
            step++;
        }

        return -1;
    }
}
