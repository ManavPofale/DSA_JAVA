class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] pcount = new int[26];
        int[] win = new int[26];
        int k = p.length();
        int left = 0;
        for(int i = 0; i < p.length(); i++){
            pcount[p.charAt(i) - 'a']++;
        }
        for(int right = 0; right < s.length(); right++){
            win[s.charAt(right) - 'a']++;
            if(right - left + 1 == k){
                if(Arrays.equals(win, pcount)){
                    list.add(left);
                }
                win[s.charAt(left) - 'a']--;
                left++;
            } 
        }
        return list;
    }
}