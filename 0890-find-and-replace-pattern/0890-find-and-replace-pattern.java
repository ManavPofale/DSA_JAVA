class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();

        for(String word : words){
            if(isMatch(word, pattern)){
                ans.add(word);
            }
        }
        return ans;
    }
    public boolean isMatch(String s, String t){
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.indexOf(s.charAt(i))!=t.indexOf(t.charAt(i))){
                return false;
            }    
        }
        return true;
    }
}