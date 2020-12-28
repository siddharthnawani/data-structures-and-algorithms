package src.com.sid.companyBasedQuestions.amazon.TreesAndGraphs;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 * 210. Course Schedule II
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
 **/
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int pair[] : prerequisites) {
            List<Integer> neighbour = adjList.getOrDefault(pair[1], new ArrayList<>());
            neighbour.add(pair[0]);
            adjList.put(pair[1], neighbour);
            indegree[pair[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int index = 0;
        int[] topologicalOrder = new int[numCourses];
        while (!q.isEmpty()) {
            int course = q.poll();
            topologicalOrder[index++] = course;
            if (adjList.containsKey(course)) {
                for (int neighbor : adjList.get(course)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0)
                        q.add(neighbor);
                }
            }

        }

        if (index == numCourses)
            return topologicalOrder;
        else return new int[0];
    }
}
