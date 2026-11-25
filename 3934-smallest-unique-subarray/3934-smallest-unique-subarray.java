
class Solution {
    long mod1 = 1000000007L;
    long mod2 = 1000000009L;
    long base1 = 911382323L;
    long base2 = 972663749L;

    long[] h1, h2, p1, p2;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        h1 = new long[n + 1];
        h2 = new long[n + 1];
        p1 = new long[n + 1];
        p2 = new long[n + 1];

        p1[0] = p2[0] = 1;

        for (int i = 0; i < n; i++) {
            h1[i + 1] = (h1[i] * base1 + nums[i]) % mod1;
            h2[i + 1] = (h2[i] * base2 + nums[i]) % mod2;

            p1[i + 1] = p1[i] * base1 % mod1;
            p2[i + 1] = p2[i] * base2 % mod2;
        }

        int low = 1, high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (check(mid, n)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    boolean check(int len, int n) {
        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i + len <= n; i++) {
            int j = i + len;

            long a = (h1[j] - h1[i] * p1[len] % mod1 + mod1) % mod1;
            long b = (h2[j] - h2[i] * p2[len] % mod2 + mod2) % mod2;

            long hash = a * mod2 + b;

            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }

        for (int count : map.values()) {
            if (count == 1) return true;
        }

        return false;
    }
}
