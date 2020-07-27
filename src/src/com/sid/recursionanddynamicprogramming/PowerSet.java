package src.com.sid.recursionanddynamicprogramming;

import java.util.ArrayList;
import java.util.List;

//78. Subsets
public class PowerSet {

    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        dfs(S,0,res,curr);
        return res;
    }

    private void dfs(int[] s, int i, List<List<Integer>> res, List<Integer> curr) {
        if(i==s.length)
        {
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(s[i]);
        dfs(s,i+1,res,curr);
        curr.remove(curr.size()-1);
        dfs(s,i+1,res,curr);
    }

    //ToDO one with duplicates

    public static void main(String[] args) {
       int[] nums = {1,2,3};
        System.out.println(new PowerSet().subsets(nums));

        int[] nums2 = {1,2,2};
        System.out.println(new PowerSet().subsets(nums2));
    }
        public String restoreString(String s, int[] indices) {

            char[] r=new char[s.length()];
            int j=0;
            for(char s1: s.toCharArray()){
                r[indices[j]]=s1;
                j++;
            }
            return String.valueOf(r);
        }
}
