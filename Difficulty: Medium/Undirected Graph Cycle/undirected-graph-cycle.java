import java.util.*;

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, adj, visited)) return true;
            }
        }

        return false;
    }

    public boolean bfs(int start, List<List<Integer>> adj, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, -1});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }

        return false;
    }
}