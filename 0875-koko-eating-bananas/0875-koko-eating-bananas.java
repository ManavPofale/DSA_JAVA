// class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
//         int left = 1;
//         int right = 0;
//         for (int pile : piles) {
//             right = Math.max(right, pile);
//         }
//         int ans = right;
//         while (left <= right) {
//             int mid = left + (right - left) / 2;
//             long hours = 0;
//             for (int pile : piles) {
//                 hours += (pile + mid - 1) / mid;   
//             }
//             if (hours <= h) {
//                 ans = mid;
//                 right = mid - 1;
//             } else {
//                 left = mid + 1;
//             }
//         }
//         return ans;
//     }
// }


class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1, r=0;
        for (int pile:piles){
            r=Math.max(r, pile);
        }
        while(l<r){
            int mid=l+(r-l)/2;
            if(isValid(piles, mid, h)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    public boolean isValid(int[] piles, int mid, int h){
        int ch=0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]%mid==0 ){
                ch+=piles[i]/mid;
            }else{
                ch+=(piles[i]/mid)+1;
            }
        }
        return ch<=h;
    }
}    