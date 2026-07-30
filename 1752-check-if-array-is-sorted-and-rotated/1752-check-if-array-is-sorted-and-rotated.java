// class Solution {
//     public boolean check(int[] nums) {
//         int n = nums.length;

//         for(int k = 0; k < n; k++) {
//             int[] rotated = new int[n];
//             // rotate array by k
//             for(int i = 0; i < n; i++) {
//                 rotated[(i + k) % n] = nums[i];
//             }
//             if(isSorted(rotated)) {
//                 return true;
//             }
//         }
//         return false;
//     }
//     private boolean isSorted(int[] arr) {

//         for(int i = 1; i < arr.length; i++) {
//             if(arr[i] < arr[i-1]) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }

//optimal solution

class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            if(count > 1) {
                return false;
            }
        }
        return true;
    }
}