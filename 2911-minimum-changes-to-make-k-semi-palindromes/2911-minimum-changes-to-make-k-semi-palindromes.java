class Solution {
    
    public int minimumChanges(String s, int k) {
        int n = s.length();

        // Cost of converting each substring
        int[][] cost = buildCost(s);

        // DP table
        int[][] dp = new int[k + 1][n + 1];

        int INF = 1_000_000;

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        // Base case
        dp[0][0] = 0;

        // Next: calculate dp transitions

        for (int p = 1; p <= k; p++) {
            for (int j = 2 * p; j <= n; j++) {

                for (int i = 2 * (p - 1); i <= j - 2; i++) {

                    if (dp[p - 1][i] == INF)
                        continue;

                    int totalChanges = dp[p - 1][i] + cost[i][j - 1];

                    dp[p][j] = Math.min(dp[p][j], totalChanges);
                }
            }
        }

        return dp[k][n];
    }

    private int[][] buildCost(String s) {
        int n = s.length();
        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                // Calculate cost[i][j]
                cost[i][j] = minChangesSemiPalindrome(s.substring(i, j + 1));
            }
        }

        return cost;
    }

    private int countChanges(String s, int d) {
        int changes = 0;
        int n = s.length();

        for (int offset = 0; offset < d; offset++) {

            int left = offset;
            int right = n - d + offset;

            while (left < right) {

                if (s.charAt(left) != s.charAt(right))
                    changes++;

                left += d;
                right -= d;
            }
        }

        return changes;
    }

    private int minChangesSemiPalindrome(String s) {
        int n = s.length();
        int minChanges = Integer.MAX_VALUE;

        for (int d = 1; d < n; d++) {

            // 1. Check whether d divides n exactly
            if(n % d == 0) {
            // 2. Calculate countChanges(s, d)
            // 3. Update minChanges
                minChanges = Math.min(minChanges, countChanges(s, d));
            }
        }

        return minChanges;
    }
}