import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK{

    public int subarraySum(int[] nums, int k) {
       
        //cal prefix sum
        int len=nums.length,sum=0,count=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
 
        for(int i=0;i<len;i++){
            sum +=nums[i];
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
 
         return count;
     }
}git statu