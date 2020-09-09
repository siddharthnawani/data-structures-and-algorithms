package src.com.sid.misc;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/discuss/interview-question/835684/microsoft-oa-question
 * <p>
 * Question :
 * <p>
 * You are given an input array which contains the points of the swimmers so far,
 * now there is the final race, where maximum points is equal to N (Total no of participants)
 * , then runner up will get N-1, then the next one N-2.. and so on . The last one will have 1 point.
 * <p>
 * Output the no if champions which can be the winner.
 * <p>
 * Input :
 * 3
 * 8 10 9
 * <p>
 * O/p:
 * 3
 * Possibility of score : 8+3=11,9+2=11,10+1=11; so all can win
 * <p>
 * I/p 2:
 * 5
 * 15 14 15 12 14
 * O/P
 * 4
 * <p>
 * Even we give the highest point to 12 ie 12+5=17, the next min would be atleast 14+4=18, hence be the champion. therefore only 4 swimmers
 */
public class SwimmingChampionship {
    /**
     * assuming we've sorted the participants by score and iterating through the scores from highest to lowest:
     * <p>
     * The first swimmer can clearly be the winner since they get impeccable a[0] + N
     * The second swimmer can win if their total plus the highest number of points per race
     * is higher than the leader plus the lowest reward, i.e. if a[1] + N > a[0] + 1.
     * All other participants don't matter because none of them can beat a[1] if he/she wins the race.
     * The third swimmer can win if their score is higher than both a[0] + 1 and a[1] + 2 and so on.
     * Actually, instead of comparing to all previous participants, there should be a variable that
     * stores the maximum value calculated at previous steps.
     */
    private int findChampions(Integer[] points) {
        Arrays.sort(points, Comparator.reverseOrder());
        int maxsofar = 0;
        int N = points.length;
        for (int i = 0; i < points.length; i++) {
            if (points[i] + N < maxsofar)
                return i;
            //Allot min points
            maxsofar = Math.max(points[i] + i + 1, maxsofar);

        }
        return N;
    }

    public static void main(String[] args) {
        Integer[] points = {8, 10, 9};
        System.out.println(new SwimmingChampionship().findChampions(points));
        Integer[] points2 = {15, 14, 15, 12, 14};
        System.out.println(new SwimmingChampionship().findChampions(points2));
    }
}
