class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length, ans = 0;
        for(int k=1;k<=n;k++){
            if(n%k!=0) continue;
            if(check(nums, n, k)) ans += k;
        }
        return ans;
    }
    private boolean check(int[] a, int n, int k){
        int prevMax = 0;
        for(int i=0;i<n;i+=k){
            int drops = 0, dropIdx = -1;
            for(int j=0;j<k;j++){
                if(a[i+j]>a[i+(j+1)%k]){
                    drops++;
                    dropIdx = j;
                }
            }
            if(drops > 1) return false;
            int min = (drops == 0) ? a[i] : a[i + (dropIdx + 1) % k];
            int max = (drops == 0) ? a[i] : a[i + dropIdx];
            if(i>0 && prevMax>min) return false;
            prevMax = max;
        }
        return true;
    }
}