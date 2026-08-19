class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minspeed = 1;
        int maxspeed = 0;
        for(int pile : piles){
            maxspeed = Math.max(pile, maxspeed);
        }
        while(minspeed<maxspeed){
            int mid = minspeed + (maxspeed - minspeed) / 2;
            if(caneatintime(piles, h, mid)){
                maxspeed = mid;
            }else{
                minspeed = mid + 1;
            }
        }
        return minspeed;
    }
    public boolean caneatintime(int[] piles, int h, int mid){
        long hours = 0;
        for(int pile : piles){
            hours += (int)Math.ceil((double)pile/mid);
        }
        return hours<=h;
    }
}