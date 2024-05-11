class Solution {
    static List<Long> jugglerSequence(long n) {
        List<Long> res = new ArrayList<>();
        res.add(n);

        while (n > 1) {
            if (n % 2 == 1)
                n = (long) (Math.sqrt(n) * n);
            else
                n = (long) Math.sqrt(n);

            res.add(n);
        }

        return res;
    }}
