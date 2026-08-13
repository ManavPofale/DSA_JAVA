class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        int ans = 0;
        while (n >= d) {
            long temp = d;
            int count = 1;
            while (n >= temp + temp) {
                temp += temp;
                count += count;
            }
            n -= temp;
            ans += count;
        }
        return isNegative ? -ans : ans;
    }
}