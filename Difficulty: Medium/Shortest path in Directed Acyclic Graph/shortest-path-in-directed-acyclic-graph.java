class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {

        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        int[] indegree = new int[V];

        for(int i = 0; i < V; i++) {
            for(int[] neigh : adj.get(i)) {
                indegree[neigh[0]]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> topo = new ArrayList<>();

        while(!q.isEmpty()) {

            int node = q.poll();

            topo.add(node);

            for(int[] neigh : adj.get(node)) {

                indegree[neigh[0]]--;

                if(indegree[neigh[0]] == 0) {
                    q.offer(neigh[0]);
                }
            }
        }

        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;

        for(int node : topo) {

            if(dist[node] != Integer.MAX_VALUE) {

                for(int[] neigh : adj.get(node)) {

                    int v = neigh[0];
                    int wt = neigh[1];

                    if(dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        for(int i = 0; i < V; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}