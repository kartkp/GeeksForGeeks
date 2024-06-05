class Solution {
    long findSwapValues(long[] a, int n, long[] b, int m) {
        long sumA = 0;
        for (long num : a) sumA += num;
        long sumB = 0;
        for (long num : b) sumB += num;
        if ((sumA - sumB) % 2 != 0) return -1;
        long target = (sumA - sumB) / 2;
        Set<Long> setB = new HashSet<>();
        for (long num : b) setB.add(num);
        for (long num : a) {
            if (setB.contains(num - target)) {
                return 1;
            }
        }

        return -1;
    }
}
