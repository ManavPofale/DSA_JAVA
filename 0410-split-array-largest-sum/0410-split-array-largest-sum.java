class Solution {
    public int splitArray(int[] nums, int k) {
        int l=0;
        int r=0;
        for(int num : nums){
            l=Math.max(l, num);
             r+=num;
        }
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isValid(nums, mid, k)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    public boolean isValid(int[] nums, int mid, int k){
        int sum=0, currentKcount=1;
        for(int num : nums){
            if(sum+num>mid){
                sum=0;
                currentKcount++;
                sum=num;
            }else{
                sum+=num;
            }
        }
        return currentKcount<=k;
    }
}