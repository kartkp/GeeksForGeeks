class Solution {
    public static boolean hasFour(int n) {
        while (n > 0) {
            if (n % 10 == 4) return true;
            n /= 10;
        }
        return false;
    }

    public static int countNumberswith4(int n) {
        int ans = 0;
        for (int i = 0; i <= n; ++i) {
            if (hasFour(i)) ++ans;
        }
        return ans;
    }
}
