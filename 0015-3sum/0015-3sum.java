// class Solution {
//     public List<List<Integer>> threeSum(int nums[]){
//         List<List<Integer>> ans = new ArrayList<>();
//         int n = nums.length;
//         Arrays.sort(nums);
        
//         for(int i=0;i<n-2;i++){
//             if(i>0 && nums[i]==nums[i-1])
//                 continue;
//             int left = i+1;
//             int right = n-1;

//             while(left<right){
//                 int sum = nums[i]+nums[left]+nums[right];
//                 if(sum == 0){
//                     ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
//                     left++;
//                     right--;
//                     while(left<right && nums[left] == nums[left-1]){
//                         left++;
//                     }
//                     while(left<right && nums[right] == nums[right+1]){
//                         right--;
//                     }
//                 }else if(sum<0){
//                     left++;
//                 }else{
//                     right--;
//                 }
//             }
//         }    
//         return ans;
//     }
// }

// using hashset
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            Set<Integer> seen = new HashSet<>();
            for(int j=i+1;j<n;j++){
                int complement = -nums[i] - nums[j];
                if(seen.contains(complement)){
                    ans.add(Arrays.asList(nums[i], complement, nums[j]));  
                    while (j+1<n && nums[j] == nums[j+1]){
                        j++;
                    }
                }
                seen.add(nums[j]);
            }
        }
        
        return ans;
    }
}