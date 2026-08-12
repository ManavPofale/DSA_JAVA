class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l=1;
        int r=0;
        int ans=r;
        for(int num:nums){
            r=Math.max(r, num);
        }
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isValid(mid, nums, threshold)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    public boolean isValid(int mid, int[] nums, int threshold){
        int sum=0;
        for(int num:nums){
            sum+=(num+mid-1)/mid;
            if(sum>threshold){
                return false;
            }
        }
        return true;

    }
}