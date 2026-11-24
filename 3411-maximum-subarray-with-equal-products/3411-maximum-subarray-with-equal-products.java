class Solution {
    private static final long MAX_LCM = 2520L;

    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 1;
        for(int i=0;i<n;i++){
            long prod = 1L;
            int gcdVal = 0;
            long lcmVal = 1L;
            for(int j=i;j<n;j++){
                int x = nums[j];
                prod *= x;
                gcdVal = (j == i) ? x : gcd(gcdVal, x);
                lcmVal = lcm(lcmVal, x);
                long rhs = lcmVal * gcdVal;
                if(prod == rhs){
                    maxLen = Math.max(maxLen, j - i + 1);
                }
                if (prod > MAX_LCM*lcmVal*gcdVal){
                    break;
                }
            }
        }
        return maxLen;
    }
    private int gcd(int a, int b){
        while(b!=0){
            int temp = a % b;
            a=b;
            b=temp;
        }
        return a;
    }
    private long lcm(long a, long b){
        return (a / gcd((int) a, (int) b)) * b;
    }
}