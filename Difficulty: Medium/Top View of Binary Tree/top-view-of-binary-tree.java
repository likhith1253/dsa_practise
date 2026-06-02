/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    private static class QueueObj {
        Node node;
        int hd;
        
        QueueObj(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Map<Integer,Integer> topviewmap = new HashMap<>();
        Queue<QueueObj> q = new LinkedList<>();
        
        int minhd = 0;
        int maxhd = 0;
        q.add(new QueueObj(root,0));
        
        while(!q.isEmpty()){
            QueueObj curr = q.poll();
            Node node = curr.node;
            int hd = curr.hd;
            
            if(!topviewmap.containsKey(hd)){
                topviewmap.put(hd,node.data);
            }
            
            minhd = Math.min(minhd, hd);
            maxhd = Math.max(maxhd,hd);
            if (node.left != null) {
                q.add(new QueueObj(node.left, hd - 1));
            }
            if (node.right != null) {
                q.add(new QueueObj(node.right, hd + 1));
            }
        }
        for (int i = minhd; i <= maxhd; i++) {
            if (topviewmap.containsKey(i)) {
                result.add(topviewmap.get(i));
            }
        }

        return result;
        
    }
}