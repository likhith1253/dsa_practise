import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : times){
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int dcurr = curr[1];
            
            if(dcurr > distance[u]){
                continue;
            }
            
            for(int[] arr: adj.get(u)){
                int v = arr[0];
                int d = arr[1];
                
                if(dcurr + d < distance[v]){
                    distance[v] = dcurr + d;
                    pq.offer(new int[]{v, distance[v]});
                }
            }
        }
        
        int mintime = 0;
        for(int i = 1; i <= n; i++){
            if(distance[i] == Integer.MAX_VALUE){
                return -1;
            }
            mintime = Math.max(mintime, distance[i]);
        }
        
        return mintime;
    }
}