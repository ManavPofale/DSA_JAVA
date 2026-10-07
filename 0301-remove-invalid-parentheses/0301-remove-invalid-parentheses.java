class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int leftRem = 0;
        int rightRem = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                leftRem++;
            }else if(ch == ')'){
                if(leftRem > 0){
                    leftRem--;
                }else{
                    rightRem++;
                }
            }
        }

        Set<String> resultSet = new HashSet<>();
        dfs(s, 0, leftRem, rightRem, 0, new StringBuilder(), resultSet);
        return new ArrayList<>(resultSet);
    }

    private void dfs(String s, int index, int leftRem, int rightRem, int openCount, 
                     StringBuilder current, Set<String> resultSet){
        if(index == s.length()){
            if(leftRem == 0 && rightRem == 0 && openCount == 0){
                resultSet.add(current.toString());
            }
            return;
        }

        char ch = s.charAt(index);
        int len = current.length();
        if(ch == '(' && leftRem > 0){
            dfs(s, index + 1, leftRem - 1, rightRem, openCount, current, resultSet);
        }else if(ch == ')' && rightRem > 0){
            dfs(s, index + 1, leftRem, rightRem - 1, openCount, current, resultSet);
        }
        current.append(ch);

        if(ch != '(' && ch != ')'){
            dfs(s, index + 1, leftRem, rightRem, openCount, current, resultSet);
        }else if(ch == '('){
            dfs(s, index + 1, leftRem, rightRem, openCount + 1, current, resultSet);
        }else if(ch == ')' && openCount > 0){
            dfs(s, index + 1, leftRem, rightRem, openCount - 1, current, resultSet);
        }
        current.setLength(len);
    }
}