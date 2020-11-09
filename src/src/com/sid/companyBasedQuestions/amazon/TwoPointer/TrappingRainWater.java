package src.com.sid.companyBasedQuestions.amazon.TwoPointer;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * <p>
 * 42. Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 **/
public class TrappingRainWater {


    public int trap(int[] height) {

        int lo = 0, h = height.length - 1, ans = 0;
        int l_max = 0, r_max = 0;


        while (lo < h) {
            //in this case the smaller left wall will decide how much water can be held
            if (height[lo] < height[h]) {

                if (l_max <= height[lo]) {
                    l_max = height[lo];
                } else {
                    ans += l_max - height[lo];
                }
                lo++;

            }//in this case the smaller right wall decide how much water can be held
            else {
                if (height[h] >= r_max) {
                    r_max = height[h];
                } else {
                    ans += r_max - height[h];
                }
                h--;
            }
        }

        return ans;

    }


    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new TrappingRainWater().trap(height));
    }
}
