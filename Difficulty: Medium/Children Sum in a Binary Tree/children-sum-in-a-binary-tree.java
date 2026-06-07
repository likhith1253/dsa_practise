class Solution {
    public static boolean isSumProperty(Node root) {
        // Base case: null nodes or leaf nodes automatically satisfy the property
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        
        int sum = 0;
        if (root.left != null) {
            sum += root.left.data;
        }
        if (root.right != null) {
            sum += root.right.data;
        }
        
        // The current node must pass, AND both subtrees must pass
        if (root.data == sum 
            && isSumProperty(root.left) == true 
            && isSumProperty(root.right) == true) {
            return true;
        }
        
        return false;
    }
}