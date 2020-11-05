package src.com.sid.tree.SimilarQuestion1;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 * There are a total of n courses you have to take labelled from 0 to n - 1.
 * <p>
 * Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.
 * <p>
 * Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * <p>
 * If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 * <p>
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 * <p>
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 ***/
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //make adjacency list
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int des = prerequisites[i][0];
            int src = prerequisites[i][1];

            List<Integer> lst = adj.getOrDefault(src, new ArrayList<>());
            lst.add(des);
            adj.put(src, lst);

            indegree[des]++;
        }

        //cal indegree
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int index = 0;
        int[] topSort = new int[numCourses];
        //start bfs
        while (q.size() > 0) {
            int node = q.poll();
            topSort[index++] = node;

            if (adj.containsKey(node)) {
                for (int neighbor : adj.get(node)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }

        if (index == numCourses)
            return topSort;

        return new int[0];
    }
    public int[] findOrderUsingDFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) adj.add(i, new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++) adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!topologicalSort(adj, i, stack, visited, new boolean[numCourses])) return new int[0];
        }
        int i = 0;
        int[] result = new int[numCourses];
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    private boolean topologicalSort(List<List<Integer>> adj, int v, Stack<Integer> stack, boolean[] visited, boolean[] isLoop) {
        if (visited[v]) return true;
        if (isLoop[v]) return false;
        isLoop[v] = true;
        for (Integer u : adj.get(v)) {
            if (!topologicalSort(adj, u, stack, visited, isLoop)) return false;
        }
        visited[v] = true;
        stack.push(v);
        return true;
    }

    public static void main(String[] args) {
        int numCourses=4;
        int[][] prerequisites={{1,0},{2,0},{3,1},{3,2}};

        System.out.println("Using BFS");
        int[] sol=new CourseScheduleII().findOrder(numCourses,prerequisites);
        for(int i=0;i<sol.length;i++){
            System.out.print(sol[i]+" ");
        }
        System.out.println("\nUsing DFS");
        sol=new CourseScheduleII().findOrderUsingDFS(numCourses,prerequisites);
        for(int i=0;i<sol.length;i++){
            System.out.print(sol[i]+" ");
        }

    }
}
