// class Solution {
//     public int findDuplicate(int[] nums) {
//         int n=nums.length;
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 if(nums[i]==nums[j]){
//                     return nums[i];
//                 }
//             }
//         }
//         return -1;
//     }
// }

class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = 1;
        while (r < nums.length) {
            if (nums[l] == nums[r]) {
                return nums[l];
            }
            l++;
            r++;
        }
        return -1;
    }
}