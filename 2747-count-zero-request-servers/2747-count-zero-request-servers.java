class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length, ans[] = new int[m], serverCount[] = new int[n + 1], active = 0;
        
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        
        int[][] q = new int[m][2];
        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));
        
        int left = 0, right = 0;
        for (int i = 0; i < m; i++) {
            int start = q[i][0] - x, end = q[i][0];
            
            while (right < logs.length && logs[right][1] <= end) {
                if (serverCount[logs[right++][0]]++ == 0) active++;
            }
            
            while (left < logs.length && logs[left][1] < start) {
                if (--serverCount[logs[left++][0]] == 0) active--;
            }
            
            ans[q[i][1]] = n - active;
        }
        
        return ans;
    }
}