class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        dfsrecursive(adj,0,visited,result);
        return result;
    }
    public void dfsrecursive(ArrayList<ArrayList<Integer>> adj, int node, 
    boolean[] visited,ArrayList<Integer>result){
        visited[node] = true;
        result.add(node);
        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                dfsrecursive(adj,neighbor,visited,result);
            }
        }
    }
  
}