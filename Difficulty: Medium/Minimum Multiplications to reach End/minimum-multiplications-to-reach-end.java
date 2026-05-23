class Solution {

    int minSteps(int[] arr, int start, int end) {

        if(start == end)
            return 0;

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[1000];

        q.offer(new int[]{start, 0});
        visited[start] = true;

        while(!q.isEmpty()) {

            int[] curr = q.poll();

            int num = curr[0];
            int steps = curr[1];

            for(int x : arr) {

                int newNum = (num * x) % 1000;

                if(newNum == end)
                    return steps + 1;

                if(!visited[newNum]) {

                    visited[newNum] = true;

                    q.offer(new int[]{newNum, steps + 1});
                }
            }
        }

        return -1;
    }
}