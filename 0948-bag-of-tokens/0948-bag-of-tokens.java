class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        int n = tokens.length;
        Arrays.sort(tokens);
        int left = 0;
        int right = n-1;

        while(left<=right){
            if(n==0) return 0;
            if(power>=tokens[left]){
                power -= tokens[left];
                score++;
                left++;
            }else if(left<right && score>0){
                power += tokens[right];
                score--;
                right--;
            }else{
                return score;
            }
        }

        return score;
    }
}