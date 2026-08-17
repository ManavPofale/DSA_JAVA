// merge and sort => tc-O((m+n)log(m+n)), sc- O(m+n)
// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int m=nums1.length;
//         int n=nums2.length;
//         int[] mergedarray=new int[m+n];
//         for(int i=0;i<m;i++){
//             mergedarray[i] = nums1[i];
//         }
//         for(int j=0;j<n;j++){
//             mergedarray[m+j] = nums2[j];
//         }
//         Arrays.sort(mergedarray);
//         int len = mergedarray.length;

//         if(len % 2 == 0){
//             return (mergedarray[len/2 -1] + mergedarray[len/2]) / 2.0;
//         }else{
//             return (mergedarray[len/2]);
//         }
//     }
// }

// two pointer merge approach => tc-O(m+n), sp-O(1)
// class Solution{
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int n = nums1.length;
//         int m = nums2.length;
//         int t = n + m;
//         int i = 0, j = 0;
//         int prev = 0, curr = 0;
//         for(int cnt = 0; cnt <= t/2; cnt++){
//             prev = curr;
//             if(i < n && (j >= m || nums1[i] <= nums2[j])){
//                 curr = nums1[i];
//                 i++;
//             }else{
//                 curr = nums2[j];
//                 j++;
//             }
//         }
//         if(t % 2 == 0) return (prev + curr)/2.0;
//         return curr;
//     }
// }

// Binary Search approach => tc-O(log(m+n)), sc-O(1)
class Solution{
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length, n = nums2.length;
        int low = 0, high = m;
        while(low <= high){
            int partition1 = low + (high - low) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1){
                if((m + n) % 2 == 0){
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }else{
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                high = partition1 - 1; // Move left in nums1
            }else{
                low = partition1 + 1;  // Move right in nums1
            }
        }
        return 0.0;
    }
}