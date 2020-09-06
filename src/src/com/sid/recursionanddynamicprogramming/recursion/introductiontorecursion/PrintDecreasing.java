package src.com.sid.recursionanddynamicprogramming.recursion.introductiontorecursion;

public class PrintDecreasing {
    private void printDecreasing(int n){
        if(n==0) return;
        System.out.println(n);
        printDecreasing(n-1);
    }

    public static void main(String[] args) {
        int n=5;
        new PrintDecreasing().printDecreasing(n);
    }
}
