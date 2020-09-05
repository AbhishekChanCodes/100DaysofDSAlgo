/*

LeetCode Problem 867

Transpose Matrix

Given a matrix A, return the transpose of A.

The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.

Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
Example 2:

Input: [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]


*/


/*

Approach: There is no trick approach to this problem. It just requires a good understanding of how 2D arrays work
          and to be careful of the indexing. This is a good starting problem for 2D arrays.


Time Complexity: O(R * C) where R is number of rows and C is number of columns.

*/




public int[][] transpose(int[][] A) {

        int rowlength = A.length;
        int columnlength = A[0].length;

        int[][] result = new int[columnlength][rowlength];

        for(int i = 0;i < rowlength;i++)
        {
            for(int j = 0;j < columnlength;j++)
            {
                result[j][i] = A[i][j];
            }
        }

        return result;
}
