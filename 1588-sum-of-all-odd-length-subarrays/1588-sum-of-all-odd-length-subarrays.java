class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n=arr.length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }

                if((j-i+1)%2==1){
                    ans+=sum;
                }
            }
        }
        return ans;
    }
}