class Solution {
    public int[] rearrangeArray(int[] nums) {
        if(nums == null){
            return null;
        }
        int n = nums.length;
        int[] negative = new int[n/2];
        int[] positive = new int[n/2];
        int indexn = 0;
        int indexp = 0;
        for(int i =0; i<nums.length;i++){
            if(nums[i] < 0){
                negative[indexn] = nums[i];
                indexn++;
            }
            if(nums[i]>=0){
                positive[indexp] = nums[i];
                indexp++;
            }
        }
        int x = 0;
        int y =0;

        for(int j =0;j<n;j = j+2){
            nums[j] = positive[x];
            nums[j+1] = negative[y];
            x++;
            y++;
        }
        return nums;

    }
}