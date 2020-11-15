package src.com.sid.companyBasedQuestions.amazon.Matrix;

/***
 * https://www.youtube.com/watch?v=HxMngN22YzA
 * https://leetcode.com/problems/rotate-image/
 *
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 *
 * **/
public class RotateImage {
    public void rotate(int[][] matrix) {

        //the idea is to move in rectangular rings while replcing the first element with the outermost 3 remaining corners of the retangular circles


        //we start from the 1 row and traverse only till half squeezing the rings towards inside, so finally we only have to traverse till half the matrix
        int lo = 0;
        int hi = matrix.length - 1;


        while (lo < hi) {

            //intenally we have to move from starting till end index -1
            int width = hi - lo;

            for (int i = 0; i < width; i++) {
                int swapIdx = lo + i;
                //top left with top right - of current rectangle
                swap(matrix, lo, swapIdx, lo + i, hi);
                //top left with bottom right - of current rectangle
                swap(matrix, lo, swapIdx, hi, hi - i);
                //top left with bottom left
                swap(matrix, lo, swapIdx, hi - i, lo);

            }

            //squeeze the triangle
            lo++;
            hi--;

        }
    }


    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {

        //swap x1y1 --> x2y2
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new RotateImage().rotate(matrix);

        //display
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
