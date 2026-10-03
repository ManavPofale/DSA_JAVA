class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,new ArrayList<>(),new boolean[nums.length],ans);
        return ans;
    }
    public void helper(int[] nums,List<Integer> current, boolean[] valid,List<List<Integer>> ans){
        if(current.size()==nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(valid[i]) continue;
            valid[i]=true;
            current.add(nums[i]);

            helper(nums, current, valid, ans);

            valid[i]=false;
            current.remove(current.size()-1);
            
        }
    }
}