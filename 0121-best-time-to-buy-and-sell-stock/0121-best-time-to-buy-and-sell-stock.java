class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buyit = prices[0];
        int profit = 0;
        for(int i=0;i<n;i++){
            if(buyit>prices[i]){
                buyit = prices[i];
            }
            profit = Math.max(profit, prices[i] - buyit);
        }
        return profit;
    }
}