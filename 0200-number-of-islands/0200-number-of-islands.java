class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, boolean[][] visited, int i, int j) {
       
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }

       
        if (grid[i][j] == '0' || visited[i][j]) {
            return;
        }

        
        visited[i][j] = true;

     
        dfs(grid, visited, i + 1, j); 
        dfs(grid, visited, i - 1, j); 
        dfs(grid, visited, i, j + 1); 
        dfs(grid, visited, i, j - 1); 
    }
}