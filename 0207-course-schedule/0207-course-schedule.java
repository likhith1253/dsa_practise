class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {

            if (state[i] == 0) {

                if (dfs(i, graph, state)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int node,
                       List<List<Integer>> graph,
                       int[] state) {

        if (state[node] == 1) {
            return true;
        }

        if (state[node] == 2) {
            return false;
        }

        state[node] = 1;

        for (int neighbor : graph.get(node)) {

            if (dfs(neighbor, graph, state)) {
                return true;
            }
        }

        state[node] = 2;

        return false;
    }
}