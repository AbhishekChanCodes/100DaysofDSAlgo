/*

LeetCode Problem 1277

Count Square Submatrices with All Ones

Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation:
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.


Example 2:

Input: matrix =
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation:
There are 6 squares of side 1.
There is 1 square of side 2.
Total number of squares = 6 + 1 = 7.

*/





/*

Approach: Parse through the matrix from beginning. If any element is one, then it definitely is a square of size 1.
          Besides that, we also check if it is a square of size 2 or more.

          If matrix[i][j] = 1, then we find min(matrix[i-1][j], matrix[i][j-1], matrix[i-1][j-1]) + 1.
          This is the size of the largest square possible, for which A[i][j] is the bottom-right corner.

          Repeat these steps and update the count till the bottom-right corner of the original matrix.

Time Complexity: O(MN) where M and N are the sizes of the matrix

Space Complexity: O(1). However, here I have modified the input, which may be unacceptable in some cases,
                  so we can create a copy matrix and modify that with space complexity O(MN).

*/


public int countSquares(int[][] matrix) {

        int count = 0;
        for (int i = 0; i < matrix.length; ++i) {

            for (int j = 0; j < matrix[0].length; ++j) {

                if (matrix[i][j] > 0 && i > 0 && j > 0) {

                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                }

                count += matrix[i][j];
            }
        }
        return count;

}
