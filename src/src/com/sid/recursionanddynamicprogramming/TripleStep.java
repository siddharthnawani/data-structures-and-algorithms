package src.com.sid.recursionanddynamicprogramming;

public class TripleStep {

    public static  int getNumberOfWaysToclimbStairs(int steps){
        if(steps<0) return 0;
        if(steps<=2) return steps;
        
        return getNumberOfWaysToclimbStairs(steps-1)+getNumberOfWaysToclimbStairs(steps-2)+getNumberOfWaysToclimbStairs(steps-3);
    }

    public static void main(String[] args) {
        int n = 4;
        int ways = getNumberOfWaysToclimbStairs(n);
        System.out.println(ways);
    }


}
