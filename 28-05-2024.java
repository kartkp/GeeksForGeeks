class Solution {
    private int findMinCost(int index, int[] cost, int weight, int[][] memo) {
        if (weight == 0) {
            return 0;
        }
        if (index >= cost.length || index + 1 > weight) {
            return Integer.MAX_VALUE;
        }
        if (memo[index][weight] != -1) {
            return memo[index][weight];
        }

        int includeCurrent = Integer.MAX_VALUE;
        if (cost[index] != -1 && index + 1 <= weight) {
            int result = findMinCost(index, cost, weight - (index + 1), memo);
            if (result != Integer.MAX_VALUE) {
                includeCurrent = cost[index] + result;
            }
        }
        int excludeCurrent = findMinCost(index + 1, cost, weight, memo);

        memo[index][weight] = Math.min(includeCurrent, excludeCurrent);
        return memo[index][weight];
    }

    public int minimumCost(int n, int w, int[] cost) {
        int[][] memo = new int[n + 1][w + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int result = findMinCost(0, cost, w, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
