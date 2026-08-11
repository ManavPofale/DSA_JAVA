class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> map = new HashMap<>();
        for(int[] row : grid){
            String key = Arrays.toString(row);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int count = 0;
        for(int j = 0; j < n; j++){
            int[] column = new int[n];
            for(int i = 0; i < n; i++){
                column[i] = grid[i][j];
            }
            String key = Arrays.toString(column);
            count += map.getOrDefault(key, 0);
        }
        return count;
    }
}