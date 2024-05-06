class Tree{
      ArrayList<Integer> noSibling(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        findNoSibling(node, ans);
        if (ans.isEmpty())
            ans.add(-1);
        Collections.sort(ans);
        return ans;
    }

    void findNoSibling(Node node, ArrayList<Integer> ans) {
        if (node == null)
            return;

        findNoSibling(node.left, ans);

        if ((node.left != null && node.right == null) || (node.left == null && node.right != null))
            ans.add(node.left != null ? node.left.data : node.right.data);

        findNoSibling(node.right, ans);
    }
}
