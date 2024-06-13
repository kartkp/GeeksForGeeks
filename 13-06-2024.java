class Solution {
    public int padovanSequence(int n) {
        final int MOD = 1000000007;
        if (n == 0 || n == 1 || n == 2)
            return 1;

        int[] p = {1, 1, 1};
        for (int i = 3; i <= n; ++i) {
            int p_next = (p[0] + p[1]) % MOD;
            p[0] = p[1];
            p[1] = p[2];
            p[2] = p_next;
        }
        return p[2];
    }
}
