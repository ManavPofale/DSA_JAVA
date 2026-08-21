class Solution {
    public int maxWidthRamp(int[] nums) {
        int n=nums.length;
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0]!=b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        int maxwidth=0;
        int minIdx = arr[0][1];
        for(int i=0;i<n;i++){
            maxwidth=Math.max(maxwidth, arr[i][1] - minIdx);
            minIdx=Math.min(minIdx, arr[i][1]);
        }
        return maxwidth;
    }
}