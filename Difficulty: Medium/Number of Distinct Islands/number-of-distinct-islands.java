

class Solution {
    public int countDistinctIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        // HashSet stores lists of strings representing unique relative coordinate patterns
        HashSet<ArrayList<String>> distinctIslands = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Assuming 1 represents Land based on standard GeeksforGeeks problem constraints
                if (!visited[i][j] && grid[i][j] == 'L') {
                    ArrayList<String> islandShape = new ArrayList<>();
                    
                    // Launch DFS passing the current cell as both the explorer and the base origin
                    dfs(grid, visited, i, j, i, j, islandShape);
                    
                    distinctIslands.add(islandShape);
                }
            }
        }

        return distinctIslands.size();
    }

    private void dfs(char[][] grid, boolean[][] visited, int r, int c, int baseR, int baseC, ArrayList<String> shape) {
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || grid[r][c] == 'W') {
            return;
        }

        visited[r][c] = true;
        
        // Calculate relative coordinates and convert to string representation
        int relativeR = r - baseR;
        int relativeC = c - baseC;
        shape.add(relativeR + "," + relativeC);

        // Traverse in a strict deterministic order
        dfs(grid, visited, r + 1, c, baseR, baseC, shape); // Down
        dfs(grid, visited, r - 1, c, baseR, baseC, shape); // Up
        dfs(grid, visited, r, c + 1, baseR, baseC, shape); // Right
        dfs(grid, visited, r, c - 1, baseR, baseC, shape); // Left
    }
}