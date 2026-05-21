import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] effort = new int[m][n];
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        effort[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int e = curr[2];
            
            if (r == m - 1 && c == n - 1) return e;
            if (e > effort[r][c]) continue;
            
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int nextEffort = Math.max(e, Math.abs(heights[r][c] - heights[nr][nc]));
                    if (nextEffort < effort[nr][nc]) {
                        effort[nr][nc] = nextEffort;
                        pq.offer(new int[]{nr, nc, nextEffort});
                    }
                }
            }
        }
        return 0;
    }
}