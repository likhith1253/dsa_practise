import java.util.*;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }
        
        int ans = -1;
        int minReachable = n;
        
        for (int i = 0; i < n; i++) {
            int reachable = dijkstra(i, n, adj, distanceThreshold);
            if (reachable <= minReachable) {
                minReachable = reachable;
                ans = i;
            }
        }
        
        return ans;
    }
    
    private int dijkstra(int src, int n, List<List<int[]>> adj, int threshold) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.offer(new int[]{src, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];
            
            if (d > dist[u]) continue;
            
            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int w = edge[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i != src && dist[i] <= threshold) count++;
        }
        return count;
    }
}