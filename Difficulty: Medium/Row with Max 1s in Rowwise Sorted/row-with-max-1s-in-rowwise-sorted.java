class Solution {
    public int rowWithMax1s(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int maxOnes = 0;
        int ans = -1;

        for (int i = 0; i < n; i++) {
            int index = firstOne(arr[i], m);

            if (index != -1) {
                int ones = m - index;
                if (ones > maxOnes) {
                    maxOnes = ones;
                    ans = i;
                }
            }
        }

        return ans;
    }

    public int firstOne(int[] row, int m) {
        int low = 0;
        int high = m - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (row[mid] == 1) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}