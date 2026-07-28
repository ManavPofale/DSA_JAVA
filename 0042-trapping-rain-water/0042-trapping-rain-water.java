//brute force soluition

// class Solution {
//     public int trap(int[] height) {
//         int n = height.length;
//         int water = 0;
        
//         for(int i=0;i<n;i++){
//             int maxleft = height[i];
//             int maxright = height[i];
            
//             for(int j=0;j<=i;j++){
//                 maxleft = Math.max(maxleft, height[j]);
//             }
//             for(int j=i;j<n;j++){
//                 maxright = Math.max(maxright, height[j]);
//             }
//             water += Math.min(maxleft, maxright) - height[i];
//         }
//         return water;
//     }
// }

//optimal solution

class Solution {
    public int trap(int[] h) {
        int n = h.length;
        int leftmax = 0;
        int rightmax = 0;
        int left = 0;
        int right = n-1;
        int water = 0;

        while(left<=right){
            if(h[left]<=h[right]){
                if(h[left]>=leftmax){
                    leftmax = h[left];
                }else{
                    water += leftmax - h[left];
                }
                left++;
            }else{
                if(h[right]>=rightmax){
                    rightmax = h[right];
                }else{
                    water += rightmax - h[right];
                }
                right--;
            }
        }
        return water;
    }
}