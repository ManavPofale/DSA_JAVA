class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] mergedarray = new int[nums1.length + nums2.length];
        for(int i=0;i<m;i++){
            mergedarray[i] = nums1[i];
        }
        for(int j=0;j<n;j++){
            mergedarray[nums1.length + j] = nums2[j];
        }
        Arrays.sort(mergedarray);
        double median;
        if(mergedarray.length % 2 == 0){
            median=(mergedarray[mergedarray.length/2 -1] + mergedarray[mergedarray.length/2])/2.0;
        }else{
            median=(mergedarray[mergedarray.length/2]);
        }
        return median;
    }
}