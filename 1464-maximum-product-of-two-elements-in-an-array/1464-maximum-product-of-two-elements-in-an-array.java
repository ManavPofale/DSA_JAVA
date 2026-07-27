class Solution {
    public int maxProduct(int[] nums) {
        // Arrays.sort(nums);
        // int right = nums.length - 1;

        // return (nums[right] - 1) * (nums[right - 1] - 1);
        int maxproduct = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int product = (nums[i]-1) * (nums[j]-1);
                maxproduct = Math.max(maxproduct, product);
            }
        }
        return maxproduct;
    }
}