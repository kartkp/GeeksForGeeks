class Tree
{
     ArrayList<Integer> Kdistance(Node root, int k)
     {
          ArrayList<Integer> result = new ArrayList<>();
          dfs(root, k, result, 0);
          return result;
     }

    void dfs(Node node, int k, ArrayList<Integer> result, int distance) {
        if (node == null)
            return;
        if (distance == k) {
            result.add(node.data);
            return;
        }
        dfs(node.left, k, result, distance + 1);
        dfs(node.right, k, result, distance + 1);
    }}
