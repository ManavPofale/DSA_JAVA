class Solution {
    static class Node {
        int prod;
        int[] cnt;

        Node(int k) {
            this.cnt = new int[k];
            this.prod = 1;
        }
    }

    private int n;
    private int mod;
    private Node[] tree;

    private Node merge(Node left, Node right){
        Node res = new Node(mod);
        res.prod = (int) ((long) left.prod * right.prod % mod);
        for(int r = 0; r < mod; r++){
            res.cnt[r] += left.cnt[r];
            int nextRem = (int) ((long) left.prod * r % mod);
            res.cnt[nextRem] += right.cnt[r];
        }
        return res;
    }
    private void build(int node, int l, int r, int[] nums){
        if(l == r){
            tree[node] = new Node(mod);
            int val = nums[l] % mod;
            tree[node].prod = val;
            tree[node].cnt[val]++;
            return;
        }
        int mid = (l + r) >> 1;
        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }
    private void update(int node, int l, int r, int idx, int val){
        if(l == r){
            int rem = val % mod;
            tree[node].prod = rem;
            for(int i = 0; i < mod; i++){
                tree[node].cnt[i] = 0;
            }
            tree[node].cnt[rem] = 1;
            return;
        }
        int mid = (l + r) >> 1;
        if(idx <= mid){
            update(node * 2, l, mid, idx, val);
        }else{
            update(node * 2 + 1, mid + 1, r, idx, val);
        }
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node query(int node, int l, int r, int ql, int qr){
        if(ql <= l && r <= qr){
            return tree[node];
        }
        int mid = (l + r) >> 1;
        if(qr <= mid){
            return query(node * 2, l, mid, ql, qr);
        }
        if(ql > mid){
            return query(node * 2 + 1, mid + 1, r, ql, qr);
        }
        Node left = query(node * 2, l, mid, ql, qr);
        Node right = query(node * 2 + 1, mid + 1, r, ql, qr);
        return merge(left, right);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries){
        this.n = nums.length;
        this.mod = k;
        this.tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int m = queries.length;
        int[] ans = new int[m];

        for(int i = 0; i < m; i++){
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, idx, val);
            Node res = query(1, 0, n - 1, start, n - 1);
            ans[i] = res.cnt[x];
        }
        return ans;
    }
}