package src.com.sid.companyBasedQuestions.amazon.TreesAndGraphs;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 * 1376. Time Needed to Inform All Employees
 * A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company has is the one with headID.
 * <p>
 * Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also it's guaranteed that the subordination relationships have a tree structure.
 * <p>
 * The head of the company wants to inform all the employees of the company of an urgent piece of news. He will inform his direct subordinates and they will inform their subordinates and so on until all employees know about the urgent news.
 * <p>
 * The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e After informTime[i] minutes, all his direct subordinates can start spreading the news).
 * <p>
 * Return the number of minutes needed to inform all the employees about the urgent news.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1, headID = 0, manager = [-1], informTime = [0]
 * Output: 0
 * Explanation: The head of the company is the only employee in the company.
 *
 * Ref: https://leetcode.com/problems/time-needed-to-inform-all-employees/discuss/533109/Java-BFSDFS-Solutions-Clean-code
 **/
public class TimeNeededtoInformAllEmployees {
    //using bfs
    //Clone informTime and build subordinates relations;
    //Starting from headID, the root, do BFS to find the max time needed to reach the leaves.
    public int numOfMinutes_bfs(int n, int headID, int[] manager, int[] informTime) {
        int ans = 0;

        //make an array of List
        List<Integer>[] graph = new List[n];//subordinates

        //fill the graph
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1)
                graph[manager[i]].add(i);
        }

        //Now make a queue for dfs traversal
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(headID, 0));
        while (!q.isEmpty()) {
            Pair<Integer, Integer> emp = q.poll();
            int mgr = emp.getKey();
            int cumm_time = emp.getValue();

            ans = Math.max(ans, cumm_time);//max of cummulative time seen so far
            //add remaining subordinates to queue
            for (int sub : graph[mgr])
                q.add(new Pair(sub, cumm_time + informTime[mgr]));
        }
        return ans;
    }

    //Using DFS
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] graph = new List[n];//subordinates

        //fill the graph
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1)
                graph[manager[i]].add(i);
        }
        return dfs(graph, headID, informTime);
    }

    private int dfs(List<Integer>[] graph, int src, int[] informTime) {
        int max = 0;

        for (int sub : graph[src])
            max = Math.max(max, dfs(graph, sub, informTime));

        return max + informTime[src];
    }
}
