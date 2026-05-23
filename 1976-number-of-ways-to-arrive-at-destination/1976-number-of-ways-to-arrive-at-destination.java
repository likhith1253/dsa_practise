
class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<long[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            adj.get(road[0]).add(new long[]{road[1], road[2]});
            adj.get(road[1]).add(new long[]{road[0], road[2]});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        long[] ways = new long[n];
        
        dist[0] = 0;
        ways[0] = 1;
        int MOD = 1000000007;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int u = (int) curr[1];

            if (d > dist[u]) continue;

            for (long[] edge : adj.get(u)) {
                int v = (int) edge[0];
                long time = edge[1];
                long newDist = d + time;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u];
                    pq.offer(new long[]{newDist, v});
                } else if (newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}