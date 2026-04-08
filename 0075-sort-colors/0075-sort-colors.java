class Solution {
    public void sortColors(int[] nums) {
        int ones = 0;
        int zeroes = 0;
        int twos = 0;

        for(int i =0;i<nums.length; i++){
            if(nums[i] == 0){
                zeroes++;
            }
            if(nums[i] == 1){
                ones++;
            }
            if(nums[i] == 2){
                twos++;
            }
        }

        for(int i =0;i<zeroes;i++){
            nums[i] = 0;
        }
        for(int j =zeroes; j<ones+zeroes;j++){
            nums[j] = 1;
        }
        for(int k =ones+zeroes; k<twos+ones+zeroes;k++){
            nums[k] = 2;
        }
    }
}