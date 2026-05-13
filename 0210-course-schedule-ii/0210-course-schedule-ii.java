class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }

        int[] state = new int[numCourses];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {

            if (state[i] == 0) {

                if (dfs(i, graph, state, stack)) {
                    return new int[0];
                }
            }
        }

        int[] answer = new int[numCourses];

        int index = 0;

        while (!stack.isEmpty()) {
            answer[index++] = stack.pop();
        }

        return answer;
    }

    public boolean dfs(int node,
                       List<List<Integer>> graph,
                       int[] state,
                       Stack<Integer> stack) {

        if (state[node] == 1) {
            return true;
        }

        if (state[node] == 2) {
            return false;
        }

        state[node] = 1;

        for (int neighbor : graph.get(node)) {

            if (dfs(neighbor, graph, state, stack)) {
                return true;
            }
        }

        state[node] = 2;

        stack.push(node);

        return false;
    }
}