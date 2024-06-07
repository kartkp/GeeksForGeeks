class Solution {
    // Function to find the maximum occurred integer in all ranges.
    public static int maxOccured(int n, int l[], int r[], int maxx) {
        int[] a = new int[maxx + 2];
        for (int i = 0; i < n; ++i) {
            a[l[i]]++;
            if (r[i] + 1 <= maxx) {
                a[r[i] + 1]--;
            }
        }
        int maxCount = a[0], result = 0;
        for (int i = 1; i <= maxx; ++i) {
            a[i] += a[i - 1];
            if (a[i] > maxCount) {
                maxCount = a[i];
                result = i;
            }
        }
        return result;
    }
}
