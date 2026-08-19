class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=0, r=0;
        for(int weight : weights){
            l=Math.max(l, weight);
            r+=weight;
        }
        while(l<r){
            int mid = l+(r-l)/2;
            int day=1;
            int load=0;
            for(int weight : weights){
                if(load+weight>mid){
                    day++;
                    load=weight;
                }else{
                    load+=weight;
                }    
            }
            if(day>days){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
}