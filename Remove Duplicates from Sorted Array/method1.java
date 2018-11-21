class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int length = nums.length;
        int pos = 1; // because we don't need to modity the value at pos 0
        int num = 1; // the length is 1 at least. 
        for(int i = 0; i<length-1; i++){
            if(nums[i] != nums[i+1]){
                nums[pos] = nums[i+1];
                num++;
                pos++;
            }
        }
        return num;
    }
}
