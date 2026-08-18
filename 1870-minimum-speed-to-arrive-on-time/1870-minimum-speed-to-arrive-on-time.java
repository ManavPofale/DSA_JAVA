class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if (hour <= n - 1) return -1;

        int left = 1, right = 10_000_000, ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canReach(dist, hour, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean canReach(int[] dist, double hour, int speed) {
        double time = 0.0;
        int n = dist.length;

        for (int i = 0; i < n - 1; i++) {
            time += (dist[i] + speed - 1) / speed;
        }

        time += (double) dist[n - 1] / speed;
        return time <= hour;
    }
}