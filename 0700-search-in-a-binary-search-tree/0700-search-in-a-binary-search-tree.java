class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        // Base Case 1: Tree is empty or we hit a leaf's null child
        if (root == null) {
            return null;
        }
        
        // Base Case 2: Found the target node! Return it.
        if (root.val == val) {
            return root; 
        }
        
        // Recursive Case 1: Target is larger, search right subtree
        if (root.val < val) {
            return searchBST(root.right, val);
        }
        
        // Recursive Case 2: Target is smaller, search left subtree
        return searchBST(root.left, val);
    }
}
