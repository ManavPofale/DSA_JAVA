class Solution {
    public int scoreOfParentheses(String s) {
        return helper(s, 0, s.length() - 1);
    }
    private int helper(String s, int left, int right){
        int balance = 0;
        int score = 0;
        int start = left;
        for (int i = left;i <= right;i++){
            if(s.charAt(i) == '('){
                balance++;
            }else{
                balance--;
            }
            if(balance == 0){
                if(i - start == 1){
                    score += 1;
                }else{
                    score += 2 * helper(s, start + 1, i - 1);
                }
                start = i + 1;
            }
        }
        return score;
    }
}