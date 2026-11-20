class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[][] dp=new int[n][2];
        dp[0][0]=1;
        dp[0][1]=1;
        int ans=1;
        for(int i=1;i<n;i++){
            dp[i][0]=1;
            dp[i][1]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[i]-(nums[j]+1)>2){
                    break;
                }
                if(nums[j]==nums[i]-1){
                    dp[i][0]=Math.max(dp[i][0], dp[j][0]+1);
                }
                if(nums[j]+1==nums[i]-1){
                    dp[i][0]=Math.max(dp[i][0], dp[j][1]+1);
                }
                int t=nums[i];
                if(nums[j]==t){
                    dp[i][1]=Math.max(dp[i][1], dp[j][0]+1);
                }
                if(nums[j]+1==t){
                    dp[i][1]=Math.max(dp[i][1], dp[j][1]+1);
                }
            }
            ans=Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        return ans;
    }
}