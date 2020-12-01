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

    public int trap_Using_1Array_DP(int[] height) {

        //find left max upto i and save in array
        //find light max upto i and save in array
        //compute current level as curr_lvl= Min(leftmax,rightmax) -current height
        //This can be optimized further bu keeping left max in first iteration and running righr max in secind itration

        if (height.length == 0)
            return 0;
        int ans = 0;
        int[] wtr_lvl = new int[height.length];
        //find left max
        wtr_lvl[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            wtr_lvl[i] = Math.max(height[i], wtr_lvl[i - 1]);
        }
        //find running right max
        int right_max = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {

            //curr_lvl= Min(leftmax,rightmax) -current height
            int curr_water = Math.min(wtr_lvl[i], right_max) - height[i];
            if (curr_water > 0) {
                ans += curr_water;
            }
            right_max = Math.max(right_max, height[i]);
        }
        //cal ans
        return ans;
    }

    /***
     * Optimized using 2 pointers
     *
     * the idea is maintain 2 pointer l and r; the current level of water will always be decided by the smaller height;
     *
     * **/
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

    //same as above just a litle different coding style
    public int trap_Using2Pointer(int[] height) {
        if (height.length == 0) return 0;
        int l = 0, r = height.length - 1;
        int ans = 0;
        int l_max = 0, r_max = 0;

        while (l < r) {

            if (height[l] < height[r]) {

                if (height[l] >= l_max) {
                    l_max = height[l];
                } else {
                    ans += l_max - height[l];
                }
                ++l;

            } else {
                if (height[r] >= r_max) {
                    r_max = height[r];
                } else {
                    ans += r_max - height[r];
                }
                r--;
            }

        }

        return ans;
    }


    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new TrappingRainWater().trap(height));
    }
}
