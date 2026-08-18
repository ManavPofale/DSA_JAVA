// Hashset approach
// class Solution {
//     public int findPairs(int[] nums, int k) {
//         Set<Integer> uniquePairs = new HashSet<>();
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 if(Math.abs(nums[i]-nums[j])==k){
//                     uniquePairs.add(Math.min(nums[i], nums[j]));
//                 }
//             }
//         }
//         return uniquePairs.size();
//     }
// }

class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = 1;
        while (left<nums.length && right<nums.length){
            if(left==right || nums[right]-nums[left]<k){
                right++;
            }else if(nums[right]-nums[left]>k) {
                left++;
            }else{
                count++;
                left++;
                while(left<nums.length && nums[left] ==nums[left-1]){
                    left++;
                }
                if(right<=left){
                    right=left+1;
                }
            }
        }
        return count;
    }
}