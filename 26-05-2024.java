class Solution {
    private int lcs(String x, String y) {
        int n = x.length(), m = y.length();
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[m];
    }

    public int findMinCost(String x, String y, int costX, int costY) {
        int length = lcs(x, y);
        return costX * (x.length() - length) + costY * (y.length() - length);
    }
}
