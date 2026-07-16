class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
        for(int i=0;i<=n-m;i++){
            int j=0;
            while(j<m && haystack.charAt(i+j)==needle.charAt(j)){
                j++;
            }
            if(j==m){
                return i;
            }
        }
        return -1;
    }
}

// wap to blueprint of a circle , with the properties used to find its area and behaviour area of the circle. create a user logic class with two circle object and display their behaviour area of the circle