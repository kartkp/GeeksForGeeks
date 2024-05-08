class Tree{
    ArrayList<Integer> reverseLevelOrder(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (node == null)
            return ans;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                ans.add(current.data);
                
                if (current.right != null)
                    queue.add(current.right);
                if (current.left != null)
                    queue.add(current.left);
            }
        }

        Collections.reverse(ans);
        return ans;
    }
} 
