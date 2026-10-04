class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openbracket = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                openbracket.push(i);
            }else if(ch=='*'){
                star.push(i);
            }else{
                if(!openbracket.isEmpty()){
                    openbracket.pop();
                }else if(!star.isEmpty()){
                    star.pop();
                }else{
                    return false;
                }
            }
        }
        while(!openbracket.isEmpty()){
            if(star.isEmpty()){
                return false;
            }
            if(openbracket.pop()>star.pop()){
                return false;
            }
        }
        return openbracket.isEmpty();
    }
}