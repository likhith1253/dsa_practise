/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
*/

class Solution {
    public int minValue(Node root) {
        // code here
        if(root == null){
            return -1;
        }
        if(root.left == null){
            return root.data;
        }
        return minValue(root.left);
    }
}