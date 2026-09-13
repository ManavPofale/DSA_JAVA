class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;
        for(int yShift = -n + 1; yShift < n; yShift++){
            for(int xShift = -n + 1; xShift < n; xShift++){
                maxOverlap = Math.max(maxOverlap, countOverlap(img1, img2, xShift, yShift, n));
            }
        }
        return maxOverlap;
    }
    private int countOverlap(int[][] img1, int[][] img2, int xShift, int yShift, int n){
        int count = 0;
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                int r2 = r + yShift;
                int c2 = c + xShift;
                if(r2 >= 0 && r2 < n && c2 >= 0 && c2 < n){
                    if(img1[r][c] == 1 && img2[r2][c2] == 1){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}