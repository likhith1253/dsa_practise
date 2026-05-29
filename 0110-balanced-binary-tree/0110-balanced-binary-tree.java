class Solution {
    public boolean isBalanced(TreeNode root) {
        // A height of -1 indicates the tree is unbalanced.
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        // If the left subtree is unbalanced, propagate the failure up immediately
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(node.right);
        // If the right subtree is unbalanced, propagate the failure up immediately
        if (rightHeight == -1) {
            return -1;
        }

        // Check if the current node is unbalanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return the valid height of this subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}