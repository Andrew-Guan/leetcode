class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        int length = nums.length;
        int[] res = new int[length+1];
        for(int i = 0; i< length + 1; i++){
            res[i] = i+1;
        }
        for(int i = 0; i< length; i++){
            if(nums[i]>0 && nums[i]<= length+1){
                res[nums[i]-1] = 0;
            }
        }
        for(int i = 0; i< length+1; i++){
            if(res[i] != 0){
                return res[i];
            }
        }
        return 0;
    }
}
