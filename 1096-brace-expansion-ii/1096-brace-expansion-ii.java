class Solution {
    private int index = 0;

    public List<String> braceExpansionII(String expression) {
        index = 0;
        Set<String> res = parseExpr(expression);
        List<String> list = new ArrayList<>(res);
        Collections.sort(list);
        return list;
    }

    private Set<String> parseExpr(String s) {
        Set<String> unionSet = new HashSet<>();
        Set<String> productSet = new HashSet<>(Collections.singletonList(""));

        while (index < s.length() && s.charAt(index) != '}') {
            if (s.charAt(index) == ',') {
                unionSet.addAll(productSet);
                productSet = new HashSet<>(Collections.singletonList(""));
                index++;
            } else {
                Set<String> factor = parseFactor(s);
                Set<String> nextProduct = new HashSet<>();
                for (String a : productSet) {
                    for (String b : factor) {
                        nextProduct.add(a + b);
                    }
                }
                productSet = nextProduct;
            }
        }

        unionSet.addAll(productSet);
        return unionSet;
    }

    private Set<String> parseFactor(String s) {
        if (s.charAt(index) == '{') {
            index++;
            Set<String> res = parseExpr(s);
            index++;
            return res;
        } else {
            StringBuilder sb = new StringBuilder();
            while (index < s.length() && Character.isLowerCase(s.charAt(index))) {
                sb.append(s.charAt(index));
                index++;
            }
            return new HashSet<>(Collections.singletonList(sb.toString()));
        }
    }
}