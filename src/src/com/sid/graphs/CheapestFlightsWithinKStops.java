package src.com.sid.graphs;

import java.util.*;

/**
 * 787. Cheapest Flights Within K Stops
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
 * <p>
 * Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 * <p>
 * Example 1:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 * Example 2:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 **/
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //Parse the data into Hash Map
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] f : flights) {
            map.putIfAbsent(f[0], new ArrayList<>());
            map.get(f[0]).add(new int[]{f[1], f[2]});
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        q.add(new int[]{src, 0, K});
        while (!q.isEmpty()) {
            int[] c = q.poll();
            int curr = c[0];
            int cost = c[1];
            int stops = c[2];

            if (curr == dst) return cost;
            if (stops >= 0) {
                if (!map.containsKey(curr))
                    continue;
                else {
                    for (int[] next : map.get(curr)) {
                        q.add(new int[]{next[0], cost + next[1], stops - 1});
                    }
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int n = 3, src = 0, dst = 2, K = 1;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };
        System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice(n, flights, src, dst, K));

    }
}
