class Solution{
    public ArrayList<Integer> verticalSum(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> positions = new LinkedList<>();

        queue.offer(root);
        positions.offer(0);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int position = positions.poll();

            map.put(position, map.getOrDefault(position, 0) + node.data);

            if (node.left != null) {
                queue.offer(node.left);
                positions.offer(position - 1);
            }

            if (node.right != null) {
                queue.offer(node.right);
                positions.offer(position + 1);
            }
        }

        int minPosition = Collections.min(map.keySet());
        int maxPosition = Collections.max(map.keySet());
        for (int i = minPosition; i <= maxPosition; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }
}
