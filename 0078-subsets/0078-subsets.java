// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();
//         backtrack(0, nums, new ArrayList<>(), ans);
//         return ans;
//     }
//     public void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> ans){
//         ans.add(new ArrayList<>(current));
//         for(int i=index;i<nums.length;i++){
//             current.add(nums[i]); //choose
//             backtrack(i+1, nums, current, ans); //explore
//             current.remove(current.size()-1); //undo
//         }
//     }
// }

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    public void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> ans){
        if(index==nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        backtrack(index+1, nums, current, ans);

        current.remove(current.size()-1);

        backtrack(index+1, nums, current, ans);
    }
}        