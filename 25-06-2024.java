class Solution {
    int[][] rotateMatrix(int k, int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];

        k %= m;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int newCol = (j - k + m) % m;
                ans[i][newCol] = mat[i][j];
            }
        }
        return ans;
    }}
