class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length, p = 0;
        while(nums[p] != 0) p++;
        boolean inc = true, dec = true;
        for(int i=0;i<n;i++){
            if(nums[(p + i) % n] != i) inc = false;
            if(nums[(p - i + n) % n] != i) dec = false;
        }
        if(!inc && !dec) return -1;
        int ans = 1 << 30;
        if(inc) ans = Math.min(ans, Math.min(p, (n - p) % n + 2));
        if(dec) ans = Math.min(ans, Math.min(n - p, (p + 1) % n + 1));
        return ans;
    }
}