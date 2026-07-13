import java.util.*;

class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        // Minimum cost to reach each city
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        // {city, totalCost}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});

        int stops = 0;

        while (!queue.isEmpty() && stops <= k) {

            int size = queue.size();

            // Process one level (one extra flight)
            while (size-- > 0) {

                int[] curr = queue.poll();

                int city = curr[0];
                int currCost = curr[1];

                for (int[] neighbour : graph.get(city)) {

                    int nextCity = neighbour[0];
                    int price = neighbour[1];

                    int newCost = currCost + price;

                    if (newCost < cost[nextCity]) {

                        cost[nextCity] = newCost;
                        queue.offer(new int[]{nextCity, newCost});
                    }
                }
            }

            stops++;
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}