/*
Definition for Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currpath = new ArrayList<>();
        findpaths(root,result,currpath);
        return result;
    }
    void findpaths(Node root, ArrayList<ArrayList<Integer>> result,ArrayList<Integer> currpath){
        if(root == null){
            return;
        }
        currpath.add(root.data);
        if(root.left == null && root.right == null){
            result.add(new ArrayList<>(currpath));
        }
        else{
            findpaths(root.left,result,currpath);
            findpaths(root.right,result,currpath);
        }
        currpath.remove(currpath.size() - 1);
    }
}