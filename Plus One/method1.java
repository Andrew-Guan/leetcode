class Solution {
    public int[] plusOne(int[] digits) {
        //int[] digits = new int[]{9,9};
        int length = digits.length;
        if(length == 1) {
            digits[0]++;
                if(digits[0] == 10) {
                    int[] res = new int[]{1,0};
                     return res;
                } else return digits;  
        }
        
        digits[length-1]++;
        for(int i = length -1; i >0; i--){
            if(digits[i] == 10){
                digits[i] = 0;
                digits[i-1]++;
            }
        }
        
        if(digits[0] == 10) {
            int[] res = new int[1];
            res[0] = 1;
            digits[0] = 0;
            int[] output = new int[length+1];
            System.arraycopy(res, 0, output, 0, 1);
            System.arraycopy(digits, 0, output, 1, length);
            return output;
        } else return digits;
    }
}
