package src.com.sid.companyBasedQuestions.amazon.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule/
 * 207. Course Schedule
 * <p>
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 ***/
public class CourseSchedule {
    //bfs
    public boolean canFinish_bfs(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;

        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();

        for (int pair[] : prerequisites) {
            indegree[pair[0]]++;
            graph[pair[1]].add(pair[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        int count = q.size(); // How many courses don't need prerequisites. just add them
        while (!q.isEmpty()) {
            int course = q.poll();
            for (int neighbor : graph[course]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                    count++;
                }

            }
        }

        return count == numCourses;

    }

    //dfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;

        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();

        for (int pair[] : prerequisites) {
            graph[pair[1]].add(pair[0]);
        }

        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, visited))
                return false;
        }

        return true;

    }

    private boolean dfs(List<Integer>[] graph, int course, boolean[] visited) {
        if (visited[course]) // cycle is found;
            return false;
        visited[course] = true;//mark visited for current path

        //traverse neighbours
        for (int neighbor : graph[course]) {
            if (!dfs(graph, neighbor, visited))
                return false;
        }


        visited[course] = false;//remove from current path
        return true;
    }
}
