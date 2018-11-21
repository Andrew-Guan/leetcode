class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        int length = s.length();

        for(int i = 0; i< length;i++){
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
