// class Solution {
//     public int findKthPositive(int[] arr, int k) {
//         ArrayList<Integer> ans = new ArrayList<>();
//         int i=0;
//         for(int num=1;ans.size()<k;num++){
//             if(i<arr.length && arr[i] == num){
//                 i++;
//             }else{
//                 ans.add(num);
//             }
//         }
//         return ans.get(k-1);
//     }
// }

class Solution{
    public int findKthPositive(int[] arr, int k){
        int n=arr.length, l=0, r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int missing = arr[mid]-(mid+1);
            if(missing<k){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return k+l;
    }
}