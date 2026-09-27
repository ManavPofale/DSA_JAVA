class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        for(char c: s.toCharArray()){
            if(c==')'){
                StringBuilder temp=new StringBuilder();
                while(sb.length()>0 && sb.charAt(sb.length()-1)!='('){
                    temp.append(sb.charAt(sb.length()-1));
                    sb.deleteCharAt(sb.length()-1);
                }
                if(sb.length()>0){
                    sb.deleteCharAt(sb.length()-1);
                }
                sb.append(temp);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}