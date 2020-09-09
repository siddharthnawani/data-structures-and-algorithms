package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/josephus-problem-official/ojquestion
 * <p>
 * Question
 * 1. You are given two numbers N and K.
 * 2. N represents the total number of soldiers standing in a circle having position marked from 0
 * to N-1.
 * 3. A cruel king wants to execute them but in a different way.
 * 4. He starts executing soldiers from 0th position and proceeds around the circle in clockwise
 * direction.
 * 5. In each step, k-1 soldiers are skipped and the k-th soldier is executed.
 * 6. The elimination proceeds around the circle (which is becoming smaller and smaller as the
 * executed soldiers are removed), until only the last soldier remains, who is given freedom.
 * 7. You have to find the position of that lucky soldier.
 * <p>
 * Sample Input
 * 4
 * 2
 * Sample Output
 * 0
 ***/
public class JosephusProblem {

    private int solution(int n, int k) {
        //if there is only one person then its index which is 0, will be returned.
        if (n == 1)
            return 0;

        //Have faith that the lower call for n-1 will return the solution
        int lowersubsetindex = solution(n - 1, k);
        int currindex = (lowersubsetindex + k) % n;
        return currindex;
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(new JosephusProblem().solution(n, k));
    }
}
