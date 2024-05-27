class Solution {
    public int longestSubseq(int n, int[] a) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            int x = a[i];
            int len1 = dp.getOrDefault(x - 1, 0) + 1;
            int len2 = dp.getOrDefault(x + 1, 0) + 1;
            dp.put(x, Math.max(dp.getOrDefault(x, 0), Math.max(len1, len2)));
            ans = Math.max(ans, dp.get(x));
        }

        return ans;
    }
}
