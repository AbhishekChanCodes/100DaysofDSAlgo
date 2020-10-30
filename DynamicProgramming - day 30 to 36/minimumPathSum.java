/*

LeetCode Problem 64

Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

*/


/*

Approach: From the starting point, we can go either right or we can go down. So, we sum up the first row and first column.
          For the remaining grid, we find min of grid[i - 1][j] and grid[i][j - 1] and add it to the current value.
          So, when we reach the bottom right value, we always have the minimum path sum.

Time Complexity: O(M*N) where M,N are the number of rows and columns respectively.

Space Complexity: O(1). However, this solution modifies the input grid, so it might not always be acceptable.
                  In such a case, we can use other data structures and work with those.

*/

public int minPathSum(int[][] grid) {

       for(int i = 1; i < grid.length; i++) {
           grid[i][0] = grid[i - 1][0] + grid[i][0];
       }

       for(int j = 1; j < grid[0].length; j++) {
           grid[0][j] = grid[0][j - 1] + grid[0][j];
       }

       for(int i = 1; i < grid.length; i++) {

           for(int j = 1; j < grid[0].length; j++) {
               grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
           }
       }
       return grid[grid.length - 1][grid[0].length - 1];
}
