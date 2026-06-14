class Solution {
    public void moveZeroes(int[] nums) {
        int counzeros = 0;
        int pos = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[pos] = nums[i];
                pos++;
            }
            if(nums[i] == 0){
                counzeros++;
            }
        }
        for(int j = 0; j<counzeros;j++){
            nums[pos] = 0;
            pos++;
        }
    }
}