class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(isselfdriving(i)){
                ans.add(i);
            }
        }
        return ans;
    }
    public boolean isselfdriving(int num){
        int original = num;
        while(num>0){
            int digit = num%10;
            if(digit==0){
                return false;
            }if(original%digit != 0){
                return false;
            }
            num/=10;
        }
        return true;
    }
}