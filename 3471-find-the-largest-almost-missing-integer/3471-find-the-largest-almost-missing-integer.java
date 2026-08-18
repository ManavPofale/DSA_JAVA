class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[51];
        for(int i=0;i<=n-k;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=i;j<i+k;j++){
                set.add(nums[j]);
            }
            for(int x:set){
                count[x]++;
            }
        }
        for(int v=50;v>=0;v--){
            if(count[v]==1){
                return v;
            }
        }
        return -1;
    }
}