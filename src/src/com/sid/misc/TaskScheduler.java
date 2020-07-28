package src.com.sid.misc;

import java.util.Arrays;

/**
 * 621. Task Scheduler
 * You are given a char array representing tasks CPU need to do. It contains capital letters A to Z where each letter represents a different task. Tasks could be done without the original order of the array. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
 * <p>
 * However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
 * <p>
 * You need to return the least number of units of times that the CPU will take to finish all the given tasks.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 * Examp
 **/
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        for (int i = 0; i < tasks.length; i++)
            freq[tasks[i] - 'A']++;

        Arrays.sort(freq);
        int mostFreq = freq[25];
        int idleTime = (mostFreq - 1) * n; //minus 1 since we don't have to consider the last frequency of character
        for (int i = 24; i >= 0; i--) {
            idleTime -= Math.min((mostFreq - 1), freq[i]);
            if (idleTime <= 0) return tasks.length;
        }
        return tasks.length + idleTime;
    }

    public static void main(String[] args) {
        char[] arr={'A','A','A','B','B','B'};
        int n=2;
        System.out.println(new TaskScheduler().leastInterval(arr,n));
    }
}
