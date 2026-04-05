class Solution {
    static boolean searchInSorted(int nums[], int k) {
        // Your code here
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == k){
                return true;
            }
            if(nums[mid]<k){
                left = left +1;
            }
            if(nums[mid] > k){
                right = right - 1;
            }
        }
        return false;
        
    }
}