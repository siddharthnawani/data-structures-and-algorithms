package src.com.sid.bitmanipulation;

/**
 *
 * 342. Power of Four
 *
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 *
 * **/
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        int count=0;
        for(int i=0;i<=31;i++){

            if(((num>>>i) & 1) !=0){ //checkls whether bit is on or off
                count++;
                if(i%2==1) return false;
            }
        }
        if(count==1) return true;
        return false;
    }

    public static void main(String[] args) {
        int num=16;
        System.out.println(new PowerOfFour().isPowerOfFour(num));
    }
}
