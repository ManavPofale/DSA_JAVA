
import java.util.*;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len <= n; l++) {
                int r = l + len - 1;
                cost[l][r] = Integer.MAX_VALUE;

                for (int d = 1; d < len; d++) {
                    if (len % d != 0) continue;

                    int changes = 0;

                    for (int x = 0; x < d; x++) {
                        int count = (len - 1 - x) / d + 1;

                        for (int t = 0; t < count / 2; t++) {
                            int a = l + x + t * d;
                            int b = l + x + (count - 1 - t) * d;

                            if (s.charAt(a) != s.charAt(b)) {
                                changes++;
                            }
                        }
                    }

                    cost[l][r] = Math.min(cost[l][r], changes);
                }
            }
        }

        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, 1000000);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= k; i++) {
            for (int j = 2 * i; j <= n; j++) {
                for (int p = 2 * (i - 1); p <= j - 2; p++) {
                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - 1][p] + cost[p][j - 1]
                    );
                }
            }
        }

        return dp[k][n];
    }
}
