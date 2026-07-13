class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int[] mergedarray=new int[m+n];
        for(int i=0;i<m;i++){
            mergedarray[i] = nums1[i];
        }
        for(int j=0;j<n;j++){
            mergedarray[m+j] = nums2[j];
        }
        Arrays.sort(mergedarray);
        int len = mergedarray.length;

        if(len % 2 == 0){
            return (mergedarray[len/2 -1] + mergedarray[len/2]) / 2.0;
        }else{
            return (mergedarray[len/2]);
        }

    }
}