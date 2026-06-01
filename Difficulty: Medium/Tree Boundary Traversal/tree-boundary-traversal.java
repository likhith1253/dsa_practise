
class Solution {
    ArrayList<Integer> result = new ArrayList<>();

    ArrayList<Integer> boundaryTraversal(Node root) {
        if (root == null) {
            return result;
        }

        if (!isLeaf(root)) {
            result.add(root.data);
        }

        addLeftBoundary(root.left);
        addLeaves(root);
        addRightBoundary(root.right);

        return result;
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    private void addLeftBoundary(Node node) {
        Node curr = node;
        while (curr != null) {
            if (!isLeaf(curr)) {
                result.add(curr.data);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private void addLeaves(Node node) {
        if (node == null) {
            return;
        }
        if (isLeaf(node)) {
            result.add(node.data);
            return;
        }
        addLeaves(node.left);
        addLeaves(node.right);
    }

    private void addRightBoundary(Node node) {
        Node curr = node;
        Stack<Integer> st = new Stack<>();
        while (curr != null) {
            if (!isLeaf(curr)) {
                st.push(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        while (!st.isEmpty()) {
            result.add(st.pop());
        }
    }
}
