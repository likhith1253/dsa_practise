class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i =0; i<isConnected.length;i++){
            if(!visited[i]){
                count++;
                dfsrecursive(isConnected,i,visited);
            }
        }
        return count;
    }
    public void dfsrecursive(int[][] isConnected,int node,boolean[] visited){
        visited[node] = true;

        for(int i =0;i<isConnected.length;i++){
            if(isConnected[node][i] == 1 && !visited[i]){
                dfsrecursive(isConnected,i,visited);
            }
        }
    }
}