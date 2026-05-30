class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                TreeNode curr = q.poll();

                if (leftToRight) {
                    currentLevel.add(curr.val);
                } else {
                    currentLevel.add(0, curr.val);
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            result.add(currentLevel);
            leftToRight = !leftToRight;
        }

        return result;
    }
}