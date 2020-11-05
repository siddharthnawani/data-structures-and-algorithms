package src.com.sid.tree.SimilarQuestion1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 *
 * https://leetcode.com/problems/course-schedule/
 *There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 *
 * **/
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //create an adjacency list representation
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }


        int[] indegrees = new int[numCourses];
        for (int[] edge : prerequisites) {
            int s = edge[1], e = edge[0];
            graph[s].add(e);// adding directed edge
            indegrees[e]++; // indegree update for courses

        }


        //create the first batch of leaf nodes with indegree 0
        // queue intilalization and fill all courses having 0 indegree or no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        //start bfs with nodes with indegree 0
        while (queue.size() > 0) {
            int leaf = queue.poll();
            //trim the leaf
            for (int c : graph[leaf]) {
                indegrees[c]--;
                if (indegrees[c] == 0) {
                    queue.add(c);
                }
            }
            numCourses--;
        }

        return numCourses == 0;

    }

    public boolean canFinishUsingDFS(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList();

        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i))
                return false;
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course) {
        if (visited[course])
            return false;
        else
            visited[course] = true;
        ;

        for (int i = 0; i < graph[course].size(); i++) {
            if (!dfs(graph, visited, (int) graph[course].get(i)))
                return false;
        }
        visited[course] = false;
        return true;
    }

    public static void main(String[] args) {
        int numCourses=2;
        int[][] prerequisites={{1,0}};
        System.out.println(new CourseSchedule().canFinish(numCourses,prerequisites));
        System.out.println(new CourseSchedule().canFinishUsingDFS(numCourses,prerequisites));
    }
}
