class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 0;
        int[] diffCount = new int[100001];
        for (int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            diffCount[d]++;
            if (d > maxDiff) {
                maxDiff = d;
            }
        }
        long k = (long) k1 + k2;
        for (int d = maxDiff; d > 0 && k > 0; d--) {
            if (diffCount[d] == 0) {
                continue;
            }
            long count = diffCount[d];
            if (k >= count) {
                diffCount[d - 1] += count;
                diffCount[d] = 0;
                k -= count;
            } else {
                diffCount[d - 1] += k;
                diffCount[d] -= k;
                k = 0;
            }
        }
        long result = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (diffCount[d] > 0) {
                result += (long) diffCount[d] * d * d;
            }
        }
        return result;
    }
}