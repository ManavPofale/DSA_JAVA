// class Solution {
//     public int minInsertions(String s) {
//         Stack<Character> stack = new Stack<>();
//         int n=s.length();
//         int i=0;
//         int insertions=0;
//         while(i<n){
//             char c=s.charAt(i);
//             if(c=='('){
//                 stack.push(c);
//                 i++;
//             }else{
//                 if(i+1<n && s.charAt(i+1)==')'){
//                     i+=2;
//                 }else{
//                     insertions++;
//                     i++;
//                 }
//                 if(!stack.isEmpty()){
//                     stack.pop();
//                 }else{
//                     insertions++;
//                 }
//             }
//         }
//         insertions+=stack.size()*2;
//         return insertions;
//     }
// }  
//tc-O(N), sc-O(N)

class Solution {
    public int minInsertions(String s) {
        int open=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                open++;
            }else{
                if(i+1<s.length() &&  s.charAt(i+1)==')'){
                    i++;
                }else{
                    ans++;
                }
            
            if(open>0){
                open--;
            }else{
                ans++;
            }
        }
        }
        ans+=2 * open;
        return ans;
    }
}