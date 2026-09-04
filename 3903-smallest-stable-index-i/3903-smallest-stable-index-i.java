// class Solution {
//     public int firstStableIndex(int[] nums, int k) {
//         int n = nums.length;
//         for(int i=0;i<n;i++){
//             long maxvalue = Math.max(maxvalue, i);
//             for(int j=i;j<n;j++){
//                 long minvalue = Math.min(minvalue, j);
//                 if((long) (maxvalue - minvalue)>=k){
//                     return i;
//                 }
//             }
//         }
//         return -1;
//     }
// }

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            // Find max in nums[0..i]
            int maxVal = nums[0];
            for(int p=0;p<=i;p++){
                maxVal = Math.max(maxVal, nums[p]);
            }
            // Find min in nums[i..n-1]
            int minVal = nums[i];
            for(int s=i;s<n;s++){
                minVal = Math.min(minVal, nums[s]);
            }
            // Check stability condition
            if((long) maxVal-minVal<=k){
                return i;
            }
        }
        return -1;
    }
}