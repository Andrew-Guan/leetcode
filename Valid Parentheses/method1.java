class Solution {
    public boolean isValid(String s) {
        if(s == null) return false;
        if(s.length() == 0) return true;
        int length = s.length();
        Stack<Character> res = new Stack<Character>();
        for(int i = 0; i< length; i++){
            if(s.charAt(i) == '(') {
                res.push(s.charAt(i));
            }else if(s.charAt(i) == '{'){
                res.push(s.charAt(i));
            }else if(s.charAt(i) == '['){
                res.push(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                if(!res.empty()){
                    if(res.pop() == '('){
                        continue;
                    } else return false;
                } else{
                    return false;
                }
            }else if(s.charAt(i) == '}'){
                if(!res.empty()){
                    if(res.pop() == '{'){
                        continue;
                    } else return false;
                } else{
                    return false;
                }
            }else{
                if(!res.empty()){
                    if(res.pop() == '['){
                        continue;
                    } else return false;
                } else{
                    return false;
                }
            }
        }
        if(res.empty()) return true;
        else return false;
    }
}
