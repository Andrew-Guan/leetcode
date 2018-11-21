class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        int length = s.length();
        for(int i = 0; i< length-1;i++){
            String subS = s.substring(i+1);
            if(s.charAt(i)!= '0') {
                if(subS.contains(Character.toString(s.charAt(i)))){
                    s= s.replace(s.charAt(i), '0');
                }else{
                    return i;
                }
            }
        }
        if(s.charAt(length-1) == '0') return -1;
        else return length-1;
    }
}
