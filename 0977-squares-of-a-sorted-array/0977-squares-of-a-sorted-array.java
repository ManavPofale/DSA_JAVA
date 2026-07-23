// class Solution {
//     public int[] sortedSquares(int[] nums) {
//         for(int i=0;i<nums.length;i++){
//             nums[i] = nums[i]*nums[i];
//         }
//         Arrays.sort(nums);
//         return nums;   
//     }
// }


//optimal solution with tc=O(n) & sc=O(n)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int index = n-1;
        int[] ans = new int[n];
        while(left<=right){
            int leftsquare = nums[left] * nums[left];
            int rightsquare = nums[right] * nums[right];
            if(leftsquare > rightsquare){
                ans[index] = leftsquare;
                left++;
            }else{
                ans[index] = rightsquare;
                right--;
            }
            index--;
        }
        return ans;
    }
}        