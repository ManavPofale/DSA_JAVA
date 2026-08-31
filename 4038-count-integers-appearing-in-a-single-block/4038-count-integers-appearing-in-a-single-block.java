class Solution {
    public int countSpecialIntegers(int[] nums) {
        int count=0;
        for(int x=1;x<=100;x++){
            int first=-1;
            int last=-1;
            int freq=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==x){
                    if(first==-1){
                        first=i;
                    }
                    last=i;
                    freq++;
                }
            }
            if(freq>0 && last-first+1==freq){
                count++;
            }
        }
        return count;
    }
}