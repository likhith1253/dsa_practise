class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null){
            return 0;
        }
        if(nums.length == 1){
            if(nums[0] == 1){
                return 0;
            }
            else{
                return 1;
            }
        }
        int n = nums.length;
        int sum = (n*(n+1))/2;
        int arrsum = 0;
        for(int i = 0; i< nums.length; i++){
            arrsum = arrsum + nums[i];
        }
        return sum - arrsum;
    }
}