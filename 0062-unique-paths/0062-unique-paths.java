class Solution {
    public int uniquePaths(int m, int n) {
        // We only need an array of size n to represent the previous row
        int[] prevRow = new int[n];
        
        for (int i = 0; i < m; i++) {
            // Array to build the current row
            int[] currRow = new int[n];
            
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    currRow[j] = 1; // Base case: start cell
                } else {
                    int up = 0, left = 0;
                    // Paths from the cell above (from the previous row array)
                    if (i > 0) up = prevRow[j];
                    // Paths from the cell to the left (from the current row array)
                    if (j > 0) left = currRow[j - 1];
                    
                    currRow[j] = up + left;
                }
            }
            // The current row becomes the previous row for the next iteration
            prevRow = currRow;
        }
        
        // The last element of the array holds the answer for the destination cell
        return prevRow[n - 1];
    }
}