class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] state = new int[2];
        
        inorder(root, k, state);
        
        return state[1];
    }

    private void inorder(TreeNode node, int k, int[] state) {
        if (node == null || state[0] >= k) {
            return;
        }
        inorder(node.left, k, state);
        state[0]++; 
        if (state[0] == k) {
            state[1] = node.val;
            return; 
        }
        if (state[0] < k) {
            inorder(node.right, k, state);
        }
    }
}