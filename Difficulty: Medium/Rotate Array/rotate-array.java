class Solution {
    static void rotateArr(int arr[], int d) {
        int n = arr.length;
        if (n == 0) return;
        
        // Handle d > n
        d %= n;
        if (d == 0) return;

        // 1. Reverse the first d elements: [0...d-1]
        reverse(arr, 0, d - 1);
        // 2. Reverse the remaining elements: [d...n-1]
        reverse(arr, d, n - 1);
        // 3. Reverse the whole array: [0...n-1]
        reverse(arr, 0, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}