package src.com.sid.companyBasedQuestions.facebook.Math;

/**
 * https://leetcode.com/problems/mirror-reflection/
 * https://www.youtube.com/watch?v=_xIBOUWEq1c
 * https://leetcode.com/problems/mirror-reflection/discuss/146336/Java-solution-with-an-easy-to-understand-explanation
 * <p>
 * There is a special square room with mirrors on each of the four walls.  Except for the southwest corner, there are receptors on each of the remaining corners, numbered 0, 1, and 2.
 * <p>
 * The square room has walls of length p, and a laser ray from the southwest corner first meets the east wall at a distance q from the 0th receptor.
 * <p>
 * Return the number of the receptor that the ray meets first.  (It is guaranteed that the ray will meet a receptor eventually.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: p = 2, q = 1
 * Output: 2
 * Explanation: The ray meets receptor 2 the first time it gets reflected back to the left wall.
 **/
public class MirrorReflection {
    public int mirrorReflection(int p, int q) {
        int ref = 1, ext = 1;

        while (ext * p != ref * q) {
            ref++;
            ext = (ref * q) / p;
        }

        if (ext % 2 == 0 && ref % 2 != 0) return 0;
        if (ext % 2 != 0 && ref % 2 != 0) return 1;
        if (ext % 2 != 0 && ref % 2 == 0) return 2;

        return -1;
    }

    public static void main(String[] args) {
        int p = 2, q = 1;
        System.out.println(new MirrorReflection().mirrorReflection(p, q));
    }
}
