import java.util.Arrays;

class Solution {
    public int minimizeCost(int k, int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(n - 1, arr, k, dp);
    }

    private int solve(int i, int[] arr, int k, int[] dp) {
        // Base case: If we are at the 0th index, cost is 0
        if (i == 0) return 0;
        
        // Return if already computed
        if (dp[i] != -1) return dp[i];

        int minSteps = Integer.MAX_VALUE;

        // Try all possible jumps from 1 to K
        for (int j = 1; j <= k; j++) {
            // Check if jump is valid (doesn't go out of bounds)
            if (i - j >= 0) {
                int jumpCost = solve(i - j, arr, k, dp) + Math.abs(arr[i] - arr[i - j]);
                minSteps = Math.min(minSteps, jumpCost);
            } else {
                // If i - j < 0, larger jumps will also be < 0, so we can break early
                break;
            }
        }

        return dp[i] = minSteps;
    }
}