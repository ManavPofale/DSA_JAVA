class Solution {
    public boolean halvesAreAlike(String s) {
        String sb = "aeiouAEIOU";
        int count = 0;
        int n = s.length();
        for(int i=0;i<n/2;i++){
            if(sb.indexOf(s.charAt(i))!=-1){
                count++;
            }if(sb.indexOf(s.charAt(i+n/2))!=-1){
                count--;
            }
        }
        return count==0;
    }
}