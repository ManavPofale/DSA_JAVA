class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid=new String[m];
        StringBuilder firstrow=new StringBuilder();
        for(int j=0;j<n;j++){
            firstrow.append('.');
        }
        grid[0]=firstrow.toString();
        for(int i=1;i<m;i++){
            StringBuilder row=new StringBuilder();
            for(int j=0;j<n-1;j++){
                row.append('#');
            }
            row.append('.');
            grid[i]=row.toString();
        }
        return grid;
    }
}