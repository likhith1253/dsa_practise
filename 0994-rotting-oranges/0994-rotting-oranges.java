import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        
        if (count_fresh == 0) return 0;
        
        int minutes = 0;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;
            
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int[] dir : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    
                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] != 1) continue;
                    
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                    count_fresh--;
                    rottedThisMinute = true; // Flag that actual work was done
                }
            }
            // Only count the minute if an infection actually occurred
            if (rottedThisMinute) {
                minutes++;
            }
        }
        
        return count_fresh == 0 ? minutes : -1;
    }
}