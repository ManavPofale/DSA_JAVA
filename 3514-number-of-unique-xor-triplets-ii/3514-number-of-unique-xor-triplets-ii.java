class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        // Special case
        if (n == 1)
            return 1;

        // Stores all unique XORs of pairs
        HashSet<Integer> pairXor = new HashSet<>();

        // Stores all unique triplet XORs
        BitSet tripletXor = new BitSet();

        // Compute every unique pair XOR
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pairXor.add(nums[i] ^ nums[j]);
            }
        }

        // Combine every pair XOR with every element
        for (int pair : pairXor) {
            for (int num : nums) {
                tripletXor.set(pair ^ num);
            }
        }

        return tripletXor.cardinality();
    }
}