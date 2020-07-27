package src.com.sid.recursionanddynamicprogramming;

// 62. Unique Paths

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        Map<String,Integer> hm=new HashMap<>();
        return getWays(n,m,0,0,hm);
    }

    static int getWays(int r, int c, int i, int j, Map<String,Integer> hm){

        if(i >= r || i<0 || j >=c || j<0)
            return 0;
        String key=i+"#"+j;
        if(hm.containsKey(key))
            return hm.get(key);

        if(i==r-1 && j==c-1)
            return 1;

        int res= getWays(r,c,i+1,j,hm) + getWays(r,c,i,j+1,hm);
        hm.put(key,res);
        return res;

    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,3));
    }
}
