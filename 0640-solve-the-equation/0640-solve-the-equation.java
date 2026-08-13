class Solution {
    public String solveEquation(String equation) {
        String[] parts = equation.split("=");
        int[] left = evaluate(parts[0]);
        int[] right = evaluate(parts[1]);

        int coeff = left[0] - right[0];
        int constVal = right[1] - left[1];

        if (coeff == 0 && constVal == 0) {
            return "Infinite solutions";
        }
        if (coeff == 0) {
            return "No solution";
        }

        return "x=" + (constVal / coeff);
    }

    private int[] evaluate(String exp) {
        String[] tokens = exp.replace("-", "+-").split("\\+");
        int coeff = 0;
        int constVal = 0;
        for(String token : tokens){
            if(token.isEmpty()){
                continue;
            }
            if(token.equals("x") || token.equals("+x")){
                coeff += 1;
            }else if(token.equals("-x")){
                coeff -= 1;
            }else if(token.contains("x")){
                coeff += Integer.parseInt(token.replace("x", ""));
            }else{
                constVal += Integer.parseInt(token);
            }
        }
        return new int[]{coeff, constVal};
    }
}