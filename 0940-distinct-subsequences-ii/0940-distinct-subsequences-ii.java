class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long[] endsWith = new long[26];
        long total = 0;
        for(char c : s.toCharArray()){
            int idx = c - 'a';
            long currentAdded = (total + 1 - endsWith[idx] + MOD) % MOD;
            total = (total + currentAdded) % MOD;
            endsWith[idx] = (endsWith[idx] + currentAdded) % MOD;
        }
        return (int) total;
    }
}