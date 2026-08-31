// class Solution {
//     public double findMaxAverage(int[] nums, int k) {
//         int sum=0;
//         for(int left=0;left<k;left++){
//             sum+=nums[left];
//         }
//         int maxsum=sum;
//         for(int i=k;i<nums.length;i++){
//             sum+=nums[i]-nums[i-k];
//             maxsum=Math.max(maxsum, sum);
//         }
//         return (double)maxsum/k;
//     }
// }

class Solution {
    public double findMaxAverage(int[] nums, int k){
        int sum=0;
        for(int right=0;right<k;right++){
            sum+=nums[right];
        }
        int maxsum=sum;
        for(int i=k;i<nums.length;i++){
            sum+=nums[i]-nums[i-k];
            maxsum=Math.max(maxsum, sum);
        }
        return (double)maxsum/k;
    }
}    