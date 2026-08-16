import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int card : deck){
            count.put(card, count.getOrDefault(card, 0) + 1);
        }
        int g = 0;
        for(int c : count.values()){
            g = gcd(g, c);
        }
        return g >= 2;
    }
    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b,a % b);
    }
}