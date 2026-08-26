class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        long maxsum=0;
        long sum=0;
        int i=0;
        int j=0;
        while(j<nums.length){
            while(set.contains(nums[j])){
                set.remove(nums[i]);
                sum-=nums[i];
                i++;
            }
            set.add(nums[j]);
            sum+=nums[j];
            if(j-i+1==k){
                maxsum=Math.max(sum, maxsum);
                set.remove(nums[i]);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return maxsum;
    }
}