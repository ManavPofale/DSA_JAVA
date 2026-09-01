class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startR = -1, startC = -1;
        int litterCount = 0;
        int[][] litterIndex = new int[m][n];
        for(int[] row : litterIndex){
            Arrays.fill(row, -1);
        }
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                char ch = classroom[r].charAt(c);
                if(ch == 'S'){
                    startR = r;
                    startC = c;
                }else if(ch == 'L'){
                    litterIndex[r][c] = litterCount++;
                }
            }
        }
        if (litterCount == 0) return 0;
        
        int targetMask = (1 << litterCount) - 1;

        int[][][] bestEnergy = new int[m][n][1 << litterCount];
        for(int[][] mat : bestEnergy){
            for(int[] row : mat){
                Arrays.fill(row, -1);
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startR, startC, 0, energy});
        bestEnergy[startR][startC][0] = energy;

        int moves = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] curr = queue.poll();
                int r=curr[0], c=curr[1], mask=curr[2], e=curr[3];

                if(mask == targetMask){
                    return moves;
                }
                if (e == 0) continue; 
                for(int[] d : dirs){
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if(nr < 0 || nr >= m || nc < 0 || nc >= n || classroom[nr].charAt(nc) == 'X'){
                        continue;
                    }
                    int nMask = mask;
                    if(classroom[nr].charAt(nc) == 'L' && litterIndex[nr][nc] != -1){
                        nMask |= (1 << litterIndex[nr][nc]);
                    }
                    int nEnergy = e - 1;
                    if(classroom[nr].charAt(nc) == 'R'){
                        nEnergy = energy; 
                    }
                    if(nEnergy > bestEnergy[nr][nc][nMask]){
                        bestEnergy[nr][nc][nMask] = nEnergy;
                        queue.offer(new int[]{nr, nc, nMask, nEnergy});
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}