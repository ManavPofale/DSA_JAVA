import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for(int[] e : edges) g[e[0]].add(new int[]{e[1], e[2]});

        int[][] d = new int[n][k + 1];
        for(int[] r : d) Arrays.fill(r, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{d[0][1] = 0, 0, 1});

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int dist = top[0], u = top[1], c = top[2];

            if(dist > d[u][c]) continue;
            if(u == n - 1) return dist;

            for(int[] e : g[u]){
                int v = e[0], nc = (labels.charAt(u) == labels.charAt(v)) ? c + 1 : 1;
                if(nc<=k && dist+e[1]<d[v][nc]){
                    d[v][nc] = dist + e[1];
                    pq.offer(new int[]{d[v][nc], v, nc});
                }
            }
        }
        return -1;
    }
}