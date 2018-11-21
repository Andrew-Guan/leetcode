class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length ==0) return;
        int length = nums.length;
        int pointer = 0; // track non-0 numbers
        for(int i = 0; i<length;i++){ // i is used to find number 0
            if(pointer<= i) pointer = i+1;
            while(pointer<length && nums[pointer] == 0) pointer++;
            if(nums[i] == 0 && pointer<length && i<pointer){
                nums[i] = nums[pointer];
                nums[pointer] = 0;
            }
        }
        return;
    } 
}
