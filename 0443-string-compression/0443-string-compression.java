class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int k = 0;
        while(i<chars.length){
            char ch = chars[i];
            int count = 0;
            while(i<chars.length && chars[i] == ch){
                count++;
                i++;
            }
            chars[k++] = ch;
            if(count > 1){
                String num = String.valueOf(count);
                for(int j=0;j<num.length();j++){
                    chars[k++] = num.charAt(j);
                }
            }
        }
        return k;
    }
}