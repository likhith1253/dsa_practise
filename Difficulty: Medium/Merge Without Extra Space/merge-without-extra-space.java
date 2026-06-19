import java.util.Arrays;

class Solution {
    public void mergeArrays(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int left = n - 1;
        int right = 0;
                while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }
                Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}