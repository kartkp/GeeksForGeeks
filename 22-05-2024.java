class Solution {
    private int countIntervals(double x, int[] v) {
        int ret = 0;
        for (int i = 0; i < v.length - 1; i++)
            ret += (int)Math.ceil((v[i + 1] - v[i]) / x) - 1;
        return ret;
    }

    public double findSmallestMaxDist(int[] s, int k) {
        Arrays.sort(s);
        int n = s.length;
        double l = 1e-9;
        double h = s[n - 1] - s[0];
        
        while ((h - l) > 1e-6) {
            double mid = l + (h - l) / 2.0;
            int intervals = countIntervals(mid, s);
            if (intervals > k)
                l = mid;
            else
                h = mid;
        }
        return h;
    }
}
