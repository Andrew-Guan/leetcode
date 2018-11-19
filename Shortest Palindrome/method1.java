class Solution {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        StringBuilder oldS = new StringBuilder(s);
        StringBuilder newS = new StringBuilder();
        int length = s.length();
        int index = 0;
        for(int i = length; i>0;i--){
            String s1 = oldS.substring(0,i);
            oldS.reverse();
            String s2 = oldS.substring(length-i);
            oldS.reverse();
            if(s1.equals(s2)){
                index = i;
                break;
            }
        }

        String leftString = oldS.substring(index);
        newS.append(leftString);
        newS.reverse();
        newS.append(s);


        return newS.toString();
    }
}
