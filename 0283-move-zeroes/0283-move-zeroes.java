class Solution {
    public void moveZeroes(int[] nums) {
        //This moves every non-zero to the front
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=0){
                nums[i]=nums[j];
                i++;
            }
        }
        //The remaining positions should be zeros.
        while(i<nums.length){
            nums[i]=0;
            i++;
        }
    }
}