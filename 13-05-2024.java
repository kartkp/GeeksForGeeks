class Solution {
    public static int findNumberOfGoodComponent(int e, int v, int[][] edges) {
        int[] visited = new int[v + 1];
        int ans = 0;
        List<Integer>[] adj = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        for (int i = 1; i <= v; i++) {
            if (visited[i] == 0) {
                int vertices = 0;
                int edgesCount = 0;

                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                visited[i] = 1;

                while (!stack.isEmpty()) {
                    int node = stack.pop();
                    vertices++;
                    edgesCount += adj[node].size();

                    for (int neighbor : adj[node]) {
                        if (visited[neighbor] == 0) {
                            stack.push(neighbor);
                            visited[neighbor] = 1;
                        }
                    }
                }

                edgesCount /= 2;
                if (edgesCount == (vertices * (vertices - 1)) / 2) {
                    ans++;
                }
            }
        }
        return ans;

}}
