package src.com.sid.graphs;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        path.add(0);
        dfs(graph,0,path,res);
        return res;
    }
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

    public static void main(String[] args) {
        int[][] graph={{1,2},{3},{3},{}};
        System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(graph));
    }
}
