class Solution {
    public int kPalindrome(String str, int n, int k) {
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (str.charAt(i - 1) == str.charAt(n - j)) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        int lps = prev[n];
        int minDeletions = n - lps;
        return minDeletions <= k ? 1 : 0;
    }
}
