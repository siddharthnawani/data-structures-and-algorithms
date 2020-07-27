package src.com.sid.graphs;

import java.util.*;

public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        path.add(0);
        dfs(graph,0,path,res);
        return res;
    }
    //DFS
    void dfs(int[][] graph,int curr,List<Integer> path,List<List<Integer>> res){
        if(curr==graph.length-1){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int n: graph[curr]){
            path.add(n);
            dfs(graph,n,path,res);
            path.remove(path.size()-1);
        }
    }
    //BFS
    public List<List<Integer>> allPathsSourceTargetUsingBFS(int[][] graph) {
        List<List<Integer>> result = new ArrayList();
        Queue<List<Integer>> queue = new LinkedList();
        queue.add(Arrays.asList(0));

        int destinationVertex = graph.length - 1;

        while(!queue.isEmpty()) {
            List<Integer> pathSoFar = queue.poll();
            int currentVertex = pathSoFar.get(pathSoFar.size() - 1);
            // check if currentVertex is destinationVertex add pathSoFar in result
            if(currentVertex == destinationVertex) {
                result.add(new ArrayList(pathSoFar));
                continue;
            }
            for(int v : graph[currentVertex]) {
                List<Integer> newPath = new ArrayList(pathSoFar);
                newPath.add(v);
                queue.add(newPath);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] graph={{1,2},{3},{3},{}};
        System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTargetUsingBFS(graph));
    }
}
