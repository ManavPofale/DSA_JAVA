class Solution {
    public List<Integer> busiestServers(int k, int[] a, int[] l) {
        TreeSet<Integer> s = new TreeSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->x[0]-y[0]);
        int[] c = new int[k];

        for (int i = 0; i < k; i++) s.add(i);

        for (int i = 0; i < a.length; i++) {
            while (!pq.isEmpty() && pq.peek()[0] <= a[i])
                s.add(pq.poll()[1]);

            if (s.isEmpty()) continue;

            Integer x = s.ceiling(i % k);
            if (x == null) x = s.first();

            s.remove(x);
            c[x]++;
            pq.offer(new int[]{a[i] + l[i], x});
        }

        int max = Arrays.stream(c).max().getAsInt();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++)
            if (c[i] == max) ans.add(i);

        return ans;
    }
}