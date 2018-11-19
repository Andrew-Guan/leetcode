class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int conNum = 0;
        int max = 0;
        for(int num: nums){
            if(num == 1) {
                conNum++;
                max = (conNum>max)? conNum:max;
            } else {
                max = (conNum>max)? conNum:max; 
                conNum = 0;
            }
        }
        return max;
    }
}
