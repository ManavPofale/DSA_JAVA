// class Solution {
//     public int maxSubArray(int[] nums) {
//         int maxsum = Integer.MIN_VALUE;
//         for(int i=0;i<nums.length;i++){
//             int sum=0;
//             for(int j=i;j<nums.length;j++){
//                 sum+=nums[j];
//                 maxsum = Math.max(maxsum, sum);
//             }
//         }
//         return maxsum;
//     }
// }


//Kadane's algorithm(reduces the loop and start the fresh currsum)
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int cursum = nums[0];
        int maxsum = nums[0];
        for(int i=1;i<n;i++){
            cursum = Math.max(nums[i], nums[i]+cursum);
            maxsum = Math.max(maxsum, cursum);
        }
        return maxsum;
    }
}