class Solution {
    public ArrayList<Integer> getPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(-1);
        for (int i = 2; i <= n / 2; i++) {
            if (isPrime[i] && isPrime[n - i]) {
                result.set(0, i);
                result.set(1, n - i);
                break;
            }
        }

        return result;
    }
}
