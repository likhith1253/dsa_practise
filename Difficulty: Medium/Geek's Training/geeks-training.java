import java.util.Arrays;

class Solution {
    public int maximumPoints(int mat[][]) {
        int n = mat.length;

        // dp array of size N x 4 (Days x Previous Activity Options)
        int[][] dp = new int[n][4];

        // Initialize the array with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start from day 0. Pass '3' as prev because no activity was done before day 0.
        return solve(0, 3, mat, dp);
    }

    public int solve(int day, int prev, int[][] mat, int[][] dp) {
        // Base Case: If we have processed all days, no more points can be gained
        if (day == mat.length) {
            return 0;
        }

        // Memoization check: If this exact scenario was already computed, return it
        if (dp[day][prev] != -1) {
            return dp[day][prev];
        }

        int maxPoints = 0;

        // Try all 3 tasks for the current day
        for (int task = 0; task < 3; task++) {

            // Only pick the task if it is different from the previous day's task
            if (task != prev) {
                // Points gained today + max points from the remaining days
                int currentPoints = mat[day][task] + solve(day + 1, task, mat, dp);
                maxPoints = Math.max(maxPoints, currentPoints);
            }
        }

        // Store the result before returning
        return dp[day][prev] = maxPoints;
    }
}