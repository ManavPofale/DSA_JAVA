class Solution {
    public long countCommas(long n) {
        long totalCommas = 0;
        long lowerBound = 1000L;
        while(n >= lowerBound){
            totalCommas += (n - lowerBound + 1);
            if(lowerBound > Long.MAX_VALUE / 1000){
                break;
            }
            lowerBound *= 1000L;
        }
        return totalCommas;
    }
}