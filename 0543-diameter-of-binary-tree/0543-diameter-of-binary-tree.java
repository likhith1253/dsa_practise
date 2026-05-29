/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return maxDiameter;
    }

    private int calculateHeight(TreeNode node) {
        // Base case: an empty subtree has a height of 0
        if (node == null) {
            return 0;
        }

        // Step 1: Recursively get the height of the left and right subtrees
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Step 2: Calculate the diameter passing through the CURRENT node
        int currentDiameter = leftHeight + rightHeight;

        // Step 3: Update the global maximum if the current diameter is larger
        maxDiameter = Math.max(maxDiameter, currentDiameter);

        // Step 4: Return the height of the current node to its parent
        return 1 + Math.max(leftHeight, rightHeight);
    }
}