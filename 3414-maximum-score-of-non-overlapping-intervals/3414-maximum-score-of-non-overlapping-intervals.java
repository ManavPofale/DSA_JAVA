import java.util.*;

class Solution {
    static class Interval {
        int l, r, weight, id;

        Interval(int l, int r, int weight, int id) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.id = id;
        }
    }

    static class State {
        long score;
        List<Integer> ids;

        State(long score, List<Integer> ids) {
            this.score = score;
            this.ids = ids;
        }
    }

    private boolean isBetter(State a, State b) {
        if (a.score != b.score) {
            return a.score > b.score;
        }
        int len = Math.min(a.ids.size(), b.ids.size());
        for (int i = 0; i < len; i++) {
            if (!a.ids.get(i).equals(b.ids.get(i))) {
                return a.ids.get(i) < b.ids.get(i);
            }
        }
        return a.ids.size() < b.ids.size();
    }

    public int[] maximumWeight(List<List<Integer>> intervalsList) {
        int n = intervalsList.size();
        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            intervals[i] = new Interval(
                intervalsList.get(i).get(0),
                intervalsList.get(i).get(1),
                intervalsList.get(i).get(2),
                i
            );
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a.r, b.r));

        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            int low = 0, high = i - 1;
            int ans = -1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (intervals[mid].r < intervals[i].l) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            prev[i] = ans;
        }

        State[][] dp = new State[n + 1][5];
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new State(0, new ArrayList<>());
            }
        }

        for (int i = 1; i <= n; i++) {
            Interval cur = intervals[i - 1];
            int p = prev[i - 1] + 1;

            for(int k = 1; k <= 4; k++){
                dp[i][k] = dp[i - 1][k];
                State candidate = new State(0, new ArrayList<>());
                if(k == 1){
                    List<Integer> list = new ArrayList<>();
                    list.add(cur.id);
                    candidate = new State(cur.weight, list);
                }else if(dp[p][k - 1].score > 0 || dp[p][k - 1].ids.size() == k - 1){
                    List<Integer> list = new ArrayList<>(dp[p][k - 1].ids);
                    list.add(cur.id);
                    Collections.sort(list);
                    candidate = new State(dp[p][k - 1].score + cur.weight, list);
                }
                if(isBetter(candidate, dp[i][k])){
                    dp[i][k] = candidate;
                }
            }
        }
        State best = new State(0, new ArrayList<>());
        for(int k = 1; k <= 4; k++){
            if (isBetter(dp[n][k], best)){
                best = dp[n][k];
            }
        }
        int[] res = new int[best.ids.size()];
        for(int i = 0; i < best.ids.size(); i++){
            res[i] = best.ids.get(i);
        }
        return res;
    }
}