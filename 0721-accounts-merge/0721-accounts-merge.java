import java.util.*;

class Solution {

    int[] parent;
    int[] rank;

    // Find with Path Compression
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    // Union by Rank
    public void union(int u, int v) {

        int pu = find(u);
        int pv = find(v);

        if (pu == pv) {
            return;
        }

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pv] < rank[pu]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // email -> first account index that contains it
        HashMap<String, Integer> emailToAccount = new HashMap<>();

        // Step 1: Build DSU
        for (int i = 0; i < n; i++) {

            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {

                String email = account.get(j);

                if (!emailToAccount.containsKey(email)) {
                    emailToAccount.put(email, i);
                } else {
                    union(i, emailToAccount.get(email));
                }
            }
        }

        // Step 2: Group emails by parent
        HashMap<Integer, List<String>> mergedAccounts = new HashMap<>();

        for (String email : emailToAccount.keySet()) {

            int accountIndex = emailToAccount.get(email);

            int leader = find(accountIndex);

            mergedAccounts.putIfAbsent(leader, new ArrayList<>());

            mergedAccounts.get(leader).add(email);
        }

        // Step 3: Build answer
        List<List<String>> ans = new ArrayList<>();

        for (int leader : mergedAccounts.keySet()) {

            List<String> emails = mergedAccounts.get(leader);

            Collections.sort(emails);

            List<String> account = new ArrayList<>();

            // Add person's name
            account.add(accounts.get(leader).get(0));

            // Add sorted emails
            account.addAll(emails);

            ans.add(account);
        }

        return ans;
    }
}