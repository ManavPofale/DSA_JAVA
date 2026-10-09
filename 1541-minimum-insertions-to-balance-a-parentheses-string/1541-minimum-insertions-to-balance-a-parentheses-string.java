class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int n=s.length();
        int i=0;
        int insertions=0;
        while(i<n){
            char c=s.charAt(i);
            if(c=='('){
                stack.push(c);
                i++;
            }else{
                if(i+1<n && s.charAt(i+1)==')'){
                    i+=2;
                }else{
                    insertions++;
                    i++;
                }
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    insertions++;
                }
            }
        }
        insertions+=stack.size()*2;
        return insertions;
    }
}