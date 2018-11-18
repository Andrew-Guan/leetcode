class Solution {
    public boolean isPalindrome(String s) {
        // method1:
        // if(s == null) return false;
        // if(s.length() == 0) return true;
        // int length = s.length();
        // int sFlag = 0;
        // int tFlag = length - 1;
        // boolean res = true;
        // while(sFlag<tFlag){
        //     if(!checkIsAlphanumeric(s.charAt(sFlag))){
        //         sFlag++;
        //         continue;
        //     }
        //     if(!checkIsAlphanumeric(s.charAt(tFlag))){
        //         tFlag--;
        //         continue;
        //     }
        //     if(s.toLowerCase().charAt(sFlag) != s.toLowerCase().charAt(tFlag)) {
        //         res = false;
        //         break;
        //     } else {
        //         sFlag++;
        //         tFlag--;
        //     }
        // }
        // return res;
        
        // method 2:
        if(s == null) return false;
        if(s.length() == 0) return true;
        StringBuilder newString = new StringBuilder();
        String sLow = s.toLowerCase();
        int sLength = sLow.length();
        for(int i = 0; i< sLength; i++){
            if(checkIsAlphanumeric(sLow.charAt(i))){
                newString.append(sLow.charAt(i));
            }
        }
        String first = newString.toString();
        String second = newString.reverse().toString();
        if(first.equals(second)) return true;
        else return false;
    }
    public boolean checkIsAlphanumeric(char c){
        char c1 = 'a';
        char c2 = 'z';
        char c3 = 'A';
        char c4 = 'Z';
        char c5 = '0';
        char c6 = '9';
        if((c>=c1&& c<=c2)||(c>=c3&&c<=c4)||(c>=c5&&c<=c6)) return true;
        else return false;
    }
}
