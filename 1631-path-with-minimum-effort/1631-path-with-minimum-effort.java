class Solution {

    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        int[][] dist = new int[m][n];

        for(int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[2], b[2])
            );

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        dist[0][0] = 0;

        pq.offer(new int[]{0, 0, 0});

        while(!pq.isEmpty()) {

            int[] curr = pq.poll();

            int r = curr[0];
            int c = curr[1];
            int effort = curr[2];

            if(r == m - 1 && c == n - 1) {
                return effort;
            }

            if(effort > dist[r][c]) {
                continue;
            }

            for(int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];


                if(nr >= 0 && nc >= 0 && nr < m && nc < n) {

                    int newEffort = Math.max(
                        effort,
                        Math.abs(heights[r][c] - heights[nr][nc])
                    );

                    if(newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;

                        pq.offer(new int[]{nr, nc, newEffort});
                    }
                }
            }
        }

        return 0;
    }
}