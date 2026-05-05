// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<List<List<Integer>>> set = new HashSet<>();
        for(int i =0; i<grid.length;  i++){
            for(int j =0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j] == 1){
            List<List<Integer>> lst = new ArrayList<>();
            dfsrecursive(grid,i,j,visited,lst,i,j);
            set.add(lst);
        }}}
        return set.size();
    }
    
    void dfsrecursive(int[][] grid,int i, int j,boolean[][] visited,List<List<Integer>> lst,int fst,int snd){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return;
        }
        if(visited[i][j] || grid[i][j] == 0){
            return;
        }
        if(!visited[i][j] && grid[i][j] == 1){
            visited[i][j] = true;
            lst.add(Arrays.asList(i-fst,j-snd));
            dfsrecursive(grid,i+1,j,visited,lst,fst,snd);
            dfsrecursive(grid,i-1,j,visited,lst,fst,snd);
            dfsrecursive(grid,i,j+1,visited,lst,fst,snd);
            dfsrecursive(grid,i,j-1,visited,lst,fst,snd);
            
        }
    }
}
