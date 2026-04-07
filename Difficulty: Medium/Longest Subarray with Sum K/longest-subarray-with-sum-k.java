import java.util.*;

class Solution {
    public static int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Case 1: sum itself is k
            if (sum == k) {
                maxLen = i + 1;
            }

            // Case 2: check if (sum - k) exists
            if (map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                maxLen = Math.max(maxLen, len);
            }

            // Store first occurrence of sum
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, -10};
        int k = 15;

        System.out.println(longestSubarray(arr, k)); // Output: 6
    }
}