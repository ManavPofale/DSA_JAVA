// class Solution {
//   int min = Integer.MAX_VALUE;
//     public void sumMin(int[][] grid, int n, int m, int i, int j, int sum){
//      if(i==n-1 && j==m-1){
//         if(sum<min){
//             min = sum;
//         }
//         return;
//      }
//         if(j+1<m)
//          sumMin(grid, n, m,i,j+1, sum+grid[i][j+1]);

//          if(i+1<n)
//          sumMin(grid, n, m,i+1,j,  sum+grid[i+1][j]);

//     }
//     public int minPathSum(int[][] grid) {
//      sumMin(grid, grid.length, grid[0].length,0,0, grid[0][0]);
//      return min;
//     }
// }


class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // Base case: starting point
        dp[0][0] = grid[0][0];

        // Fill first column (can only come from above)
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Fill first row (can only come from the left)
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Fill the rest of the table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }
}