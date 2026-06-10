class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getLeftDepth(root);
        int rightDepth = getRightDepth(root);

        // If left and right depths are equal, it is a perfect binary tree.
        // The number of nodes is (2^height) - 1.
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1; 
        }

        // If not perfect, recursively count nodes in left and right subtrees.
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

    private int getRightDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.right;
        }
        return depth;
    }
}