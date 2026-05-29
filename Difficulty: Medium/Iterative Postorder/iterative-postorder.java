// User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Tree {
    ArrayList<Integer> postOrder(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }

        Stack<Node> st = new Stack<>();
        Node curr = node;
        Node lastVisited = null;

        while (curr != null || !st.isEmpty()) {
            // Keep moving down to the left child
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                Node peekNode = st.peek();
                // If right child exists and we are traversing up from the left child, move right
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    curr = peekNode.right;
                } else {
                    // Visit the node (both left and right subtrees are done)
                    result.add(peekNode.data);
                    lastVisited = st.pop();
                }
            }
        }

        return result;
    }
}