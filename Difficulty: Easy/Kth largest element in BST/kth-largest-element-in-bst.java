class Solution {
    public int kthLargest(Node root, int k) {
        // state[0] tracks the running count of visited nodes from largest to smallest
        // state[1] stores the final result value
        int[] state = new int[2];
        
        reverseInorder(root, k, state);
        
        return state[1];
    }

    private void reverseInorder(Node node, int k, int[] state) {
        // Base case: stop if we hit a dead end or if the answer has been found
        if (node == null || state[0] >= k) {
            return;
        }

        // 1. Traverse the right subtree (contains larger elements)
        reverseInorder(node.right, k, state);

        // 2. Process the current node
        state[0]++; // Increment the counter of visited nodes
        if (state[0] == k) {
            state[1] = node.data; // Record the k-th largest value
            return; // Abort further recursion
        }

        // 3. Traverse the left subtree (only if we still need more elements)
        if (state[0] < k) {
            reverseInorder(node.left, k, state);
        }
    }
}