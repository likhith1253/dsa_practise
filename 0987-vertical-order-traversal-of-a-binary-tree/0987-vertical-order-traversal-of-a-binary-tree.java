import java.util.*;

class Solution {
    // Custom class to hold the tracking coordinates and value of each node
    private static class Point {
        int row;
        int col;
        int val;

        Point(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Point> points = new ArrayList<>();
        
        // Step 1: Traverse the tree to populate coordinates
        extractCoordinates(root, 0, 0, points);

        // Step 2: Sort based on the three-tier priority criteria
        Collections.sort(points, (a, b) -> {
            if (a.col != b.col) {
                return Integer.compare(a.col, b.col);
            }
            if (a.row != b.row) {
                return Integer.compare(a.row, b.row);
            }
            return Integer.compare(a.val, b.val);
        });

        // Step 3: Group the sorted points into columns
        List<List<Integer>> result = new ArrayList<>();
        if (points.isEmpty()) {
            return result;
        }

        int currentCol = points.get(0).col;
        List<Integer> currentColumnList = new ArrayList<>();

        for (Point p : points) {
            if (p.col != currentCol) {
                result.add(currentColumnList);
                currentColumnList = new ArrayList<>();
                currentCol = p.col;
            }
            currentColumnList.add(p.val);
        }
        result.add(currentColumnList);

        return result;
    }

    private void extractCoordinates(TreeNode node, int row, int col, List<Point> points) {
        if (node == null) {
            // Base case: empty node
            return;
        }
        
        points.add(new Point(row, col, node.val));
        
        // Left child moves left (col - 1) and down (row + 1)
        extractCoordinates(node.left, row + 1, col - 1, points);
        
        // Right child moves right (col + 1) and down (row + 1)
        extractCoordinates(node.right, row + 1, col + 1, points);
    }
}