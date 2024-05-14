class Solution {
    public int MinimumEffort(int rows, int columns, int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
      int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        
        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int diff = curr[0];
            int row = curr[1];
            int col = curr[2];
            if (row == n - 1 && col == m - 1) {
                return diff;
            }

            for (int i = 0; i < 4; i++) {
                int newr = row + dr[i];
                int newc = col + dc[i];

                if (newr >= 0 && newr < n && newc >= 0 && newc < m) {
                    int neweffort = Math.max(Math.abs(heights[row][col] - heights[newr][newc]), diff);
                    if (neweffort < dist[newr][newc]) {
                        dist[newr][newc] = neweffort;
                        pq.offer(new int[]{neweffort, newr, newc});
                    }}}}
        return 0;
    }}
