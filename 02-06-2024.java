class Solution {
    public ArrayList<Integer> constructList(int q, int[][] queries) {
        int xr = 0;
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = q - 1; i >= 0; --i) {
            if (queries[i][0] == 0) {
                results.add(queries[i][1] ^ xr);
            } else {
                xr ^= queries[i][1];
            }
        }
        results.add(xr);
        Collections.sort(results);
        return results;
    }
}
