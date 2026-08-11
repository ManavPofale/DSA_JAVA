class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : arr){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for(int count : freq.values()){
            if(!set.add(count)){
                return false;
            }
        }
        return true;
    }
}