class Solution {

    int[] parent;
    int[] rank;

    public int findp(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = findp(parent[x]);   // Path Compression
        return parent[x];
    }

    public void union(int u, int v) {

        int pu = findp(u);
        int pv = findp(v);

        if (pu == pv)
            return;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pv] < rank[pu]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }

    public int removeStones(int[][] stones) {

        int n = stones.length;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // Union stones that share row or column
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (stones[i][0] == stones[j][0] ||
                    stones[i][1] == stones[j][1]) {

                    union(i, j);
                }
            }
        }

        int components = 0;

        for (int i = 0; i < n; i++) {
            if (findp(i) == i) {
                components++;
            }
        }

        return n - components;
    }
}