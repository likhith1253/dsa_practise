

class Solution {
    public int getSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        int largest = -1;
        int secondLargest = -1;

        for (int num : arr) {
            // Case 1: Found a new largest element
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            }
            // Case 2: Found an element between largest and second largest
            else if (num < largest && num > secondLargest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }
}

