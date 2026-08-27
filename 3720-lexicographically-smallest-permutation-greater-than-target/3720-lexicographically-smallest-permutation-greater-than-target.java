class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for(int i=0;i<n;i++){
            count[s.charAt(i) - 'a']++;
        }
        int matchLen = 0;
        while(matchLen<n && count[target.charAt(matchLen) - 'a']>0){
            count[target.charAt(matchLen) - 'a']--;
            matchLen++;
        }
        for(int i=matchLen;i>=0;i--){
            if(i<n){
                int targetChar = target.charAt(i) - 'a';
                for(int c=targetChar+1;c<26;c++){
                    if(count[c]>0){
                        StringBuilder sb = new StringBuilder(n);
                        sb.append(target, 0, i);
                        sb.append((char) ('a' + c));
                        count[c]--;
                        for(int k=0;k<26;k++){
                            while(count[k]>0){
                                sb.append((char) ('a' + k));
                                count[k]--;
                            }
                        }
                        return sb.toString();
                    }
                }
            }
            if(i>0){
                count[target.charAt(i - 1) - 'a']++;
            }
        }
        return "";
    }
}