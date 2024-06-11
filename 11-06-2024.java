class Solution {
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        List<int[]> diff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            diff.add(new int[]{Math.abs(arr[i] - brr[i]), i});
        }
        diff.sort((a, b) -> Integer.compare(b[0], a[0]));

        long ans = 0;
        for (int[] p : diff) {
            int i = p[1];
            if ((arr[i] > brr[i] && x > 0) || y == 0) {
                ans += arr[i];
                x--;
            } else {
                ans += brr[i];
                y--;
            }
        }
        return ans;
    }
}
