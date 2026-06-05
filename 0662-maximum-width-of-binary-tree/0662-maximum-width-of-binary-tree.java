import java.util.*;

class Solution {
    // Wrapper class to associate each node with its virtual heap index
    private static class QueueObj {
        TreeNode node;
        int index;

        QueueObj(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxWidth = 0;
        Queue<QueueObj> queue = new LinkedList<>();
        
        // Initialize the root at index 0
        queue.add(new QueueObj(root, 0));

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            // Track the index of the first and last node on this specific level
            int firstIndex = 0;
            int lastIndex = 0;

            for (int i = 0; i < levelSize; i++) {
                QueueObj curr = queue.poll();
                TreeNode node = curr.node;
                int currentIndex = curr.index;

                // Identify the boundaries of the current level
                if (i == 0) {
                    firstIndex = currentIndex;
                }
                if (i == levelSize - 1) {
                    lastIndex = currentIndex;
                }

                // Push left child using Heap Indexing rules: (parent_index * 2) + 1
                if (node.left != null) {
                    queue.add(new QueueObj(node.left, currentIndex * 2 + 1));
                }
                
                // Push right child using Heap Indexing rules: (parent_index * 2) + 2
                if (node.right != null) {
                    queue.add(new QueueObj(node.right, currentIndex * 2 + 2));
                }
            }

            // Compute level width and update the global maximum running width
            int currentWidth = lastIndex - firstIndex + 1;
            maxWidth = Math.max(maxWidth, currentWidth);
        }

        return maxWidth;
    }
}