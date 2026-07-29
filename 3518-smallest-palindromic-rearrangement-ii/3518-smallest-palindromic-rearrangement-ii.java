class Solution {
    private static final int LIMIT = 1_000_001;
    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int[] half = new int[26];
        StringBuilder middle = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            if (freq[i] % 2 == 1) {
                middle.append((char) ('a' + i));
            }
        }
        if (countWays(half) < k) {
            return "";
        }
        int halfLength = 0;
        for (int x : half) {
            halfLength += x;
        }

        StringBuilder left = new StringBuilder();
        for (int pos = 0; pos < halfLength; pos++) {
            for (int ch = 0; ch < 26; ch++) {
                if (half[ch] == 0)
                    continue;
                half[ch]--;
                int ways = countWays(half);
                if (ways >= k) {
                    left.append((char) ('a' + ch));
                    break;
                }
                k -= ways;
                half[ch]++;
            }
        }
        String right = left.reverse().toString();
        left.reverse();
        return left.toString() + middle.toString() + right;
    }
    // Counts number of distinct permutations
    private int countWays(int[] cnt) {
        int total = 0;
        for (int x : cnt) {
            total += x;
        }
        long ways = 1;
        for (int x : cnt) {
            if (x == 0)
                continue;
            ways *= combination(total, x);
            if (ways >= LIMIT)
                return LIMIT;
            total -= x;
        }
        return (int) ways;
    }
    // nCr (capped at LIMIT)
    private int combination(int n, int r) {
        if (r > n)
            return 0;
        r = Math.min(r, n - r);
        long ans = 1;
        for (int i = 1; i <= r; i++) {
            ans = ans * (n - i + 1) / i;
            if (ans >= LIMIT)
                return LIMIT;
        }
        return (int) ans;
    }
}