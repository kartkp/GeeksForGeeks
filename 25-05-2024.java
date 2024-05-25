class Solution {
    long max_Books(int arr[], int n, int k) {
        long max_sum = 0, current_sum = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                current_sum += arr[i];
                max_sum = Math.max(max_sum, current_sum);
            } else {
                current_sum = 0;
            }
        }
        return max_sum;
    }
}
