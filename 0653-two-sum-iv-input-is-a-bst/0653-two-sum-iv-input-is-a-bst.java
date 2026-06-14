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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> seen = new HashSet<>();
        return dfs(root,k,seen);
    }
    boolean dfs(TreeNode root, int k, Set<Integer> seen){
        if(root == null){
            return false;
        }
        int complement = k - root.val;
        if (seen.contains(complement)) {
            return true;
        }
        seen.add(root.val);
        return dfs(root.left, k, seen) || dfs(root.right, k, seen);
    }
}