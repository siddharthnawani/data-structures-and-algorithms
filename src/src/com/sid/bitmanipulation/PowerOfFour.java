package src.com.sid.bitmanipulation;

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
