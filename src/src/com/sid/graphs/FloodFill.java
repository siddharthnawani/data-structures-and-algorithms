package src.com.sid.graphs;

/**
 * 733. Flood Fill
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 * <p>
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
 * <p>
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
 * <p>
 * At the end, return the modified image.
 * <p>
 * Example 1:
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 * Note:
 * <p>
 * The length of image and image[0] will be in the range [1, 50].
 * The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 * The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 **/
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image; //when the new color is already filled.
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;

    }

    private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        //check if it goes out of boundary or it's not old color then return
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != oldColor)
            return;
        image[sr][sc] = newColor;
        dfs(image, sr + 1, sc, oldColor, newColor);
        dfs(image, sr - 1, sc, oldColor, newColor);
        dfs(image, sr, sc + 1, oldColor, newColor);
        dfs(image, sr, sc - 1, oldColor, newColor);
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        System.out.println(new FloodFill().floodFill(image, 1, 1, 2));
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++)
                System.out.print(image[i][j]);
            System.out.println();
        }
    }
}
