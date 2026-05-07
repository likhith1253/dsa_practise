class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        boolean[] visited = new boolean[V];
        Stack <Integer> st = new Stack<>();
        for(int i =0;i<V;i++){
            if(!visited[i]){
                dfs(i,visited,adj,st);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while(!st.isEmpty()){
            result.add(st.pop());
        }
        return result;
       
        
    }
    
void dfs(int i, boolean[] visited,ArrayList<ArrayList<Integer>> adj,Stack <Integer> st )
{
    visited[i] = true;
    for(int v: adj.get(i)){
        if(!visited[v]){
            dfs(v,visited,adj,st);
        }
    }
    st.push(i);
}
    
}
    
    
