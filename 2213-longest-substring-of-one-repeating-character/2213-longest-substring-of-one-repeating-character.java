class Solution {
    int[] left, right, pref, suff, max, len;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        left = new int[4 * n];
        right = new int[4 * n];
        pref = new int[4 * n];
        suff = new int[4 * n];
        max = new int[4 * n];
        len = new int[4 * n];

        build(1, 0, n - 1, s);

        int q = queryIndices.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = max[1];
        }

        return ans;
    }

    void build(int node, int l, int r, String s) {
        if (l == r) {
            left[node] = right[node] = s.charAt(l);
            pref[node] = suff[node] = max[node] = len[node] = 1;
            return;
        }

        int mid = (l + r) / 2;
        build(node * 2, l, mid, s);
        build(node * 2 + 1, mid + 1, r, s);
        merge(node);
    }

    void update(int node, int l, int r, int idx, char c) {
        if (l == r) {
            left[node] = right[node] = c;
            pref[node] = suff[node] = max[node] = len[node] = 1;
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid)
            update(node * 2, l, mid, idx, c);
        else
            update(node * 2 + 1, mid + 1, r, idx, c);

        merge(node);
    }

    void merge(int node) {
        int a = node * 2;
        int b = node * 2 + 1;

        len[node] = len[a] + len[b];
        left[node] = left[a];
        right[node] = right[b];

        pref[node] = pref[a];
        suff[node] = suff[b];
        max[node] = Math.max(max[a], max[b]);

        if (right[a] == left[b]) {
            max[node] = Math.max(max[node], suff[a] + pref[b]);

            if (pref[a] == len[a])
                pref[node] = len[a] + pref[b];

            if (suff[b] == len[b])
                suff[node] = len[b] + suff[a];
        }
    }
}