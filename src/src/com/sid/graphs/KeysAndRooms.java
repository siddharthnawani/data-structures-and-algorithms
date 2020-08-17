package src.com.sid.graphs;

import java.util.*;

/**
 * 841. Keys and Rooms
 * <p>
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
 * <p>
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 * <p>
 * Initially, all the rooms start locked (except for room 0).
 * <p>
 * You can walk back and forth between rooms freely.
 * <p>
 * Return true if and only if you can enter every room.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We start in room 0, and pick up key 1.
 * We then go to room 1, and pick up key 2.
 * We then go to room 2, and pick up key 3.
 * We then go to room 3.  Since we were able to go to every room, we return true.
 * Example 2:
 * <p>
 * Input: [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can't enter the room with number 2.
 */
public class KeysAndRooms {
    /**
     * Using BFS
     * */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        bfsHelper(rooms, 0, visited);
        for (int v = 1; v < visited.length; v++) {
            if (!visited[v])
                return false;
        }
        return true;
    }

    private void bfsHelper(List<List<Integer>> rooms, int sv, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

        visited[sv] = true;
        for (int v : rooms.get(sv)) {
            q.offer(v);
            visited[v] = true;
        }

        while (!q.isEmpty()) {
            Integer v = q.poll();
            for (int node : rooms.get(v)) {
                if (!visited[node]) {
                    q.offer(node);
                    visited[node] = true;
                }
            }
        }
    }
    /**
     * USing DFS
     * **/
    public boolean canVisitAllRoomsUsingDFS(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfsHelper(rooms, 0, visited);
        visited[0]=true;
        for (int v = 1; v < visited.length; v++) {
            if (!visited[v])
                return false;
        }
        return true;
    }

    private void dfsHelper(List<List<Integer>> rooms, int sv, boolean[] visited) {
        for(int v:rooms.get(sv)){
            if(!visited[v]){
                visited[v]=true;
                dfsHelper(rooms,v,visited);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> adj_list = new ArrayList<>();
        adj_list.add(Arrays.asList(1));
        adj_list.add(Arrays.asList(2));
        adj_list.add(Arrays.asList(3));
        adj_list.add(Arrays.asList());
        System.out.println(new KeysAndRooms().canVisitAllRooms(adj_list));
        System.out.println(new KeysAndRooms().canVisitAllRoomsUsingDFS(adj_list));
    }
}
