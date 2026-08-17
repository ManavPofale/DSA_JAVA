class Solution {
    public int findKthPositive(int[] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0;
        for(int num=1;ans.size()<k;num++){
            if(i<arr.length && arr[i] == num){
                i++;
            }else{
                ans.add(num);
            }
        }
        return ans.get(k-1);
    }
}