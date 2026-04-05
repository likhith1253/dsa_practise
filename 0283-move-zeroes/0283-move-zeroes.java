class Solution {
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i =0; i<nums.length; i++){
            if(nums[i] != 0){
                result.add(nums[i]);
            }
        }
        for(int i =0; i<nums.length; i++){
            if(nums[i] == 0){
                result.add(nums[i]);
            }
        }
        for(int i = 0; i<nums.length; i++){
            nums[i] = result.get(i);
        }

    }
}