class Solution {
    ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Stack<Node> st = new Stack<>();
        st.push(root);
        
        while (!st.isEmpty()) {
            Node curr = st.pop();
            result.add(curr.data);
            
            // Push right child first so left child is processed first
            if (curr.right != null) {
                st.push(curr.right);
            }
            if (curr.left != null) {
                st.push(curr.left);
            }
        }
        return result;
    }
}