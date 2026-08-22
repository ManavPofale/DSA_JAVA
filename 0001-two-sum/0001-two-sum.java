// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int n = nums.length;
//         int[][] pairs = new int[n][2];
//         // Store value and original index
//         for(int i = 0; i < n; i++){
//             pairs[i][0] = nums[i];
//             pairs[i][1] = i;
//         }
//         // Sort based on the values
//         Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        
//         int left = 0;
//         int right = n - 1;
//         while(left < right){
//             int sum = pairs[left][0] + pairs[right][0];
            
//             if(sum == target){
//                 return new int[] { pairs[left][1], pairs[right][1] };
//             }else if(sum < target){
//                 left++;
//             }else{
//                 right--;
//             }
//         }
//         return new int[] {};
//     }
// }


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        if(nums.length == 0 || nums.length < 2){
            return ans ;
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int left = target - nums[i];
            if(map.containsKey(left)){
                return new int[] {map.get(left),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{0,0};        
    }
}