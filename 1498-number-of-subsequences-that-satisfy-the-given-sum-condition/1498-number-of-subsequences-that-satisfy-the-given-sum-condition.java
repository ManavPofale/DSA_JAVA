import java.util.Arrays;

class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1_000_000_007;
        int n = nums.length;

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Precompute powers of 2 to avoid overflow and save time
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        // Step 3: Two Pointers
        int left = 0;
        int right = n - 1;
        int count = 0;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                count = (count + power[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}