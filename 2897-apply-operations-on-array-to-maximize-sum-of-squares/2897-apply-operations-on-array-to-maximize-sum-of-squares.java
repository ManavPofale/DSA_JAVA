class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] count = new int[32];
        for(int x : nums){
            for(int i = 0;i<30;i++){
                if(((x >> i) & 1) == 1) {
                    count[i]++;
                }
            }
        }
        long ans = 0;
        long MOD = 1_000_000_007;
        for(int i = 0; i<k;i++){
            long val = 0;
            for(int bit = 0;bit < 30;bit++){
                if(count[bit] > 0){
                    val |= (1L << bit);
                    count[bit]--;
                }
            }
            ans = (ans + val * val) % MOD;
        }
        return (int) ans;
    }
}