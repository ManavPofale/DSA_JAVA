// class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
//         int l = 1;
//         int r = 0;
//         for(int pile:piles){
//             r=Math.max(r,pile);
//         }
//         while(l<=r){
//             int mid=l+(r-l)/2;
//             long hours=0;
//             for(int pile:piles){
//                 // hours+=(pile+(long) mid-1)/mid;
//                 if(pile%mid==0){
//                     hours+=pile/mid;
//                 }else{
//                     hours+=(pile/mid)+1;
//                 }
//                 if(hours>h){
//                     break;
//                 }
//             }
//             if(hours<=h){
//                 r = mid-1;
//             }else{
//                 l=mid+1;
//             }
//         }
//         return l;
//     }
// }


// using method

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canFinish(piles, h, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    private boolean canFinish(int[] piles, int h, int speed) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + (long) speed - 1) / speed;
            if (hours > h) {
                return false;
            }
        }
        return true;
    }
}