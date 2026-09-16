class Solution {
    public int numberOfSets(int n, int k) {
        int total = n + k - 1;
        int choose = 2 * k;
        int MOD = 1_000_000_007;

        long[] inv = new long[choose + 1];
        inv[1] = 1;
        for (int i = 2; i <= choose; i++) {
            inv[i] = MOD - (MOD / i) * inv[MOD % i] % MOD;
        }

        long ans = 1;
        for (int i = 1; i <= choose; i++) {
            ans = ans * (total - i + 1) % MOD;
            ans = ans * inv[i] % MOD;
        }

        return (int) ans;
    }
}