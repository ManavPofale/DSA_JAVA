class Solution {
    public int countIslands(int[][] grid, int k) {
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]>0 && dfs(grid, i, j) %k==0){
                    ans++;
                }
            }
        }
        return ans;
    }

    long dfs(int[][] g, int r, int c){
        if(r < 0 || r >= g.length || c < 0 || c >= g[0].length || g[r][c] == 0) return 0;
        long sum = g[r][c];
        g[r][c] = 0;
        return sum + dfs(g, r + 1, c) + dfs(g, r - 1, c) + dfs(g, r, c + 1) + dfs(g, r, c - 1);
    }
}