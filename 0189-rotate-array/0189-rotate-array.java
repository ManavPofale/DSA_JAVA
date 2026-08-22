// brute force solution
// class Solution {
//     public void rotate(int[] nums, int k) {
//         int n = nums.length;
//         k = k % n;

//         for(int i = 0; i < k; i++){
//             int temp = nums[n - 1];
//             for(int j = n - 1; j > 0; j--){
//                 nums[j] = nums[j - 1];
//             }
//             nums[0] = temp;
//         }
//     }
// }

// optimal solution
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    private void reverse(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}