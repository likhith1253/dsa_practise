class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] > target) {
                high = mid - 1; // Target is in the left half
            } else {
                low = mid + 1; // Target is in the right half
            }
        }
        
        // If target is not found, 'low' points to the correct insert position
        return low;
    }
}