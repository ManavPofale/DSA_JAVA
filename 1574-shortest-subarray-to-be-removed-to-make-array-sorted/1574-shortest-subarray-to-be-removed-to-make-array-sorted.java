class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        // Step 1: Find the longest non-decreasing prefix
        int left = 0;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }
        // If the whole array is already sorted
        if (left == n - 1) {
            return 0;
        }
        // Step 2: Find the longest non-decreasing suffix
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        // Initial result: either remove everything after 'left' or before 'right'
        int minLen = Math.min(n - left - 1, right);
        // Step 3: Two Pointers to merge a prefix and suffix
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                minLen = Math.min(minLen, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return minLen;
    }
}