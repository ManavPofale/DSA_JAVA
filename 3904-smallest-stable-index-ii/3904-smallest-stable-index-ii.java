// class Solution {
//     public int firstStableIndex(int[] nums, int k) {
//         int n=nums.length;
//         for(int i=0;i<n;i++){
//             int prefixmax=nums[0];
//             for(int j=0;j<=i;j++){
//                 prefixmax=Math.max(prefixmax, nums[j]);
//             }
//             int suffixmin=nums[i];
//             for(int j=i;j<n;j++){
//                 suffixmin=Math.min(suffixmin, nums[j]);
//             }
//             if(prefixmax-suffixmin<=k){
//                 return i;
//             }
//         }
//         return -1;   
//     }
// }

class Solution {
    public int firstStableIndex(int[] nums, int k){
        int n=nums.length;
        int[] suffixmin = new int[n];
        suffixmin[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffixmin[i]=Math.min(nums[i], suffixmin[i+1]);
        }
        int prefixmax=nums[0];
        for(int i=0;i<n;i++){
            prefixmax=Math.max(prefixmax, nums[i]);
            if(prefixmax-suffixmin[i]<=k){
                return i;
            }
        }
        return -1;
    }
}    