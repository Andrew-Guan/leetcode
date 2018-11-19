class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        //int[] nums = {1,1,1,1,0,1,1,1,1,1,1};
        if(nums == null || nums.length == 0) return 0;
        int conNum = 0;
        int conNumf = 0;
        int max = 0;
        boolean flipped = false;
        int tmp = 0;
        for(int num: nums){
            if(num == 1) {
                if(flipped){
                    conNumf++;
                    max = ((conNum+conNumf)>max)? conNum+conNumf:max;
                }else{
                    conNum++;
                    max = ((conNum+conNumf)>max)? (conNum+conNumf):max; 
                }
            }else if(!flipped){
                conNum++;
                flipped = true;
                conNumf = 0;
                max = ((conNum+conNumf)>max)? (conNum+conNumf):max;
            }else {
                conNum = conNumf+1;
                conNumf = 0;
                max = ((conNum+conNumf)>max)? (conNum+conNumf):max; 
            }
        }
        return max;
    }
}
