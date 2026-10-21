class Solution {
    public int minOperations(String s) {
        int n=s.length();
        boolean sorted =true;
        char minchar='z', maxchar='a';
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(i>0 && c<s.charAt(i-1)) sorted=false;
            if(c<minchar) minchar=c;
            if(c>maxchar) maxchar=c;
        }
        if(sorted) return 0;
        if(n<=2) return -1;
        if(s.charAt(0) ==minchar || s.charAt(n-1)==maxchar) return 1;

        int mincount=0, maxcount=0;
        for(char c : s.toCharArray()){
            if(c==minchar) mincount++;
            if(c==maxchar) maxcount++;
        }
        if(s.charAt(0)==maxchar && maxcount==1 && s.charAt(n-1)==minchar && mincount==1){
            return 3;
        }
        return 2;
    }
}