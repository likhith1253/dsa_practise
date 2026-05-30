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
    // Initialize to minimum possible integer to handle trees with entirely negative nodes
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateBranchSum(root);
        return maxSum;
    }

    private int calculateBranchSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively calculate left and right branch sums.
        // If a branch sum is negative, we drop it by taking Math.max(0, ...).
        int leftSum = Math.max(0, calculateBranchSum(node.left));
        int rightSum = Math.max(0, calculateBranchSum(node.right));

        // Calculate the maximum path sum that acts as a "bridge" through the current node.
        int currentPathSum = node.val + leftSum + rightSum;

        // Update the global maximum if the current path is strictly greater.
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the maximum single branch sum extending downwards from the current node.
        // A valid path can only traverse down ONE child branch, so we take the max of left/right.
        return node.val + Math.max(leftSum, rightSum);
    }
}