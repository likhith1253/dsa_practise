import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : flights) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0}); 

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        int stops = 0;

        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                int node = curr[0];
                int cost = curr[1];

                for (int[] neighbor : adj.get(node)) {
                    int nextNode = neighbor[0];
                    int edgeCost = neighbor[1];

                    if (cost + edgeCost < minCost[nextNode]) {
                        minCost[nextNode] = cost + edgeCost;
                        q.add(new int[]{nextNode, cost + edgeCost});
                    }
                }
            }
            stops++;
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}