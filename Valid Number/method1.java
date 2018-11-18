class Solution {
    public boolean isNumber(String s) {
        if(s == null) return false;
        if(s.length() == 0) return true;
        int length = s.length();
        int pointer = 0;
        int state=1;
        boolean res = false;
        // state 0 end state;
        // state 1 
        // state 2
        // state 3 
        // state 4
        // state 5 
        while(state > 0){
            if(state == 1){
                while(state == 1){
                    if(pointer >= length) return res;
                    if(s.charAt(pointer) == ' '){
                        pointer++;
                        state = 1;
                    }else if(s.charAt(pointer) == '-' || s.charAt(pointer) == '+'){
                        pointer++;
                        state = 2;
                    }else if(s.charAt(pointer) == '.'){
                        pointer++;
                        state = 8;                    
                    }else if(s.charAt(pointer) >= '0' && s.charAt(pointer) <= '9'){
                        pointer++;
                        if(pointer == length) res = true;
                        state = 3;
                    }else {
                        res = false;
                        state = 0;
                    }
                }
            }
            if(state == 2){
                while(state == 2){
                    if(pointer >= length) return res;
                    if(s.charAt(pointer) >= '0' && s.charAt(pointer) <= '9'){
                        pointer++;
                        if(pointer == length) res = true;
                        state = 3;
                    }else if(s.charAt(pointer) == ' '){
                        pointer++;
                        state = 6;
                    }else if(s.charAt(pointer) == '.'){
                        pointer++;
                        state = 8;
                    }else {
                        res = false;
                        state = 0;
                    }
                }
            }
            if(state == 3){
                while(state == 3){
                    if(pointer >= length) return res;
                    if(s.charAt(pointer) >= '0' && s.charAt(pointer) <= '9'){
                        pointer++;
                        if(pointer == length) res = true;
                        state = 3;
                    }else if(s.charAt(pointer) == '.'){
                        pointer++;
                        if(pointer == length) res = true;
                        state = 4;
                    }else if(s.charAt(pointer) == 'e'){
                        pointer++;
                        state = 5;
                    }else if(s.charAt(pointer) == ' '){
                        pointer++;
                        if(pointer == length) res = true;
                        state = 6;
                    }else {
                        res = false;
                        state = 0;
                    }
                }
            }
            if(state == 4){
                while(state == 4){
                    if(pointer >= length) return res;
                    if(s.charAt(pointer) >= '0' && s.charAt(pointer) <= '9'){
                        pointer++;
                        if(pointer == length) res = true;
                        state = 7;
                    }else if(s.charAt(pointer) == ' '){
                        pointer++;
                        if(pointer == length) res = true;
                        state = 6;
                    }else if(s.charAt(pointer) == 'e'){
                        pointer++;
                        state = 5;                        
                    }else {
                        res = false;
                        state = 0;
                    }
                }
            }
            if(state == 8){
                while(state == 8){
                    if(pointer >= length) return res;
                    if(s.charAt(pointer) >= '0' && s.charAt(pointer) <= '9'){
                        pointer++;
                        if(pointer == length) res = true;
                        state = 7;
                    }else {
                        res = false;
                        state = 0;
                    }
                }
            }                    
            if(state == 7){
                while(state == 7){
                    if(pointer >= length) return res;
                    if(s.charAt(pointer) >= '0' && s.charAt(pointer) <= '9'){
                        pointer++;
                        if(pointer == length) res = true;
                        state = 7;
                    }else if(s.charAt(pointer) == ' '){
                        pointer++;
                        if(pointer == length) res = true;
                        state = 6;
                    }else if(s.charAt(pointer) == 'e'){
                        pointer++;
                        state = 5;
                    }else {
                        res = false;
                        state = 0;
                    }
                }
            }
            if(state == 5){
                while(state == 5){
                    if(pointer >= length) return res;
                    if(s.charAt(pointer) >= '0' && s.charAt(pointer) <= '9'){
                        pointer++;
                        if(pointer == length) res = true;
                        state = 9;
                    }else if(s.charAt(pointer) == '+' || s.charAt(pointer) == '-'){
                        pointer++;
                        state = 10;                        
                    }else {
                        res = false;
                        state = 0;
                    }
                }
            }
            if(state == 10){
                while(state == 10){
                    if(pointer >= length) return res;
                    if(s.charAt(pointer) >= '0' && s.charAt(pointer) <= '9'){
                        pointer++;
                        if(pointer == length) res = true;
                        state = 9;
                    }else {
                        res = false;
                        state = 0;
                    }
                }
            }            
            if(state == 9){
                while(state == 9){
                    if(pointer >= length) return res;
                    if(s.charAt(pointer) >= '0' && s.charAt(pointer) <= '9'){
                        pointer++;
                        if(pointer == length) res = true;
                        state = 9;
                     }else if(s.charAt(pointer) == ' '){
                        pointer++;
                        if(pointer == length) res = true;
                        state = 6;
                    }else {
                        res = false;
                        state = 0;
                    }
                }
            }            
            if(state == 6){
                while(state == 6){
                    if(pointer >= length) return res;
                    if(s.charAt(pointer) == ' '){
                        pointer++;
                        if(pointer == length) res = true;
                        state = 6;
                    }else {
                        res = false;
                        state = 0;
                    }
                }
            }
        }   
        return res;
    }
}
