class Solution {
    public int maxProduct(int n) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        while(n!=0){
            int temp = n % 10;
            if(max<temp){
                max2=max;
                max=temp;
            }else if(max2<max && max2<temp){
                max2=temp;
            }
            n/=10;
        }
        return max*max2;
    }
}