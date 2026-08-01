// class Solution {

//     public boolean predictTheWinner(int[] nums) {
//         return solve(nums, 0, nums.length - 1) >= 0;
//     }

//     private int solve(int[] nums, int left, int right) {

//         if (left == right)
//             return nums[left];

//         int takeLeft = nums[left] - solve(nums, left + 1, right);

//         int takeRight = nums[right] - solve(nums, left, right - 1);

//         return Math.max(takeLeft, takeRight);
//     }
// }


// optimal solution using DP

class Solution {

    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n][n];

        // Base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        for (int len = 2; len <= n; len++) {

            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                int takeLeft = nums[i] - dp[i + 1][j];

                int takeRight = nums[j] - dp[i][j - 1];

                dp[i][j] = Math.max(takeLeft, takeRight);
            }
        }

        return dp[0][n - 1] >= 0;
    }
}