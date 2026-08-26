// class Solution {
//     public long maximumSubarraySum(int[] nums, int k) {
//         HashSet<Integer> set = new HashSet<>();
//         long maxsum=0;
//         long sum=0;
//         int i=0;
//         int j=0;
//         while(j<nums.length){
//             while(set.contains(nums[j])){
//                 set.remove(nums[i]);
//                 sum-=nums[i];
//                 i++;
//             }
//             set.add(nums[j]);
//             sum+=nums[j];
//             if(j-i+1==k){
//                 maxsum=Math.max(sum, maxsum);
//                 set.remove(nums[i]);
//                 sum-=nums[i];
//                 i++;
//             }
//             j++;
//         }
//         return maxsum;
//     }
// }


 class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum=0;
        int i=0;
        int j=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        long max=0;
        while(j<nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            
            sum+=nums[j];

            if(j-i+1==k){
                if(map.size()==k){
                    max=Math.max(max,sum);
                }

                map.put(nums[i],map.getOrDefault(nums[i],0)-1);

                if(map.get(nums[i])==0) map.remove(nums[i]);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return max;
    }
}  