class Solution {
    public int minimizeSum(int[] nums) {
        if(nums.length <= 3){
            return 0;
        }
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for(int num : nums){
            if(num<min1){
                min3 = min2;
                min2 = min1;
                min1 = num;
            }else if(num<min2){
                min3 = min2;
                min2 = num;
            }else if(num<min3){
                min3 = num;
            }
            if(num>max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }else if(num>max2){
                max3 = max2;
                max2 = num;
            }else if(num>max3){
                max3 = num;
            }
        }
        int changeTwoLargest = max3 - min1;
        int changeTwoSmallest = max1 - min3;
        int changeOneMinOneMax = max2 - min2;
        return Math.min(changeTwoLargest, Math.min(changeTwoSmallest, changeOneMinOneMax));
    }
}