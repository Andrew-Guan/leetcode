class Solution {
    public boolean isOneEditDistance(String s, String t) {
        // consider the corner cases here, null, 00,01,10
        if(s == null || t == null) return false;
        if(s.length() == 0 && t.length() == 0) return false;
        if((s.length() == 0 && t.length() == 1) || (s.length() == 1 && t.length() == 0)) return true;
        // consider other cases, check length first
        int sLength = s.length();
        int tLength = t.length();
        if(sLength == tLength){ // check replace
            int sumOfDif = 0;
            String[] sArray = s.split("");
            String[] tArray = t.split("");
            for(int i = 0; i < sLength; i++){
                if(!sArray[i].equals(tArray[i])){
                    sumOfDif++;
                }
            }
            if(sumOfDif == 1) return true;
            else return false;
        } else if(Math.abs(sLength - tLength) == 1){ // check insert or replace
            String longerOne = s;
            String shorterOne = t;
            int num = Math.min(sLength, tLength);
            if(sLength < tLength){
                longerOne = t;
                shorterOne = s;
            }
            String[] longerArray = longerOne.split("");
            String[] shorterArray = shorterOne.split("");
            int sumOfDif = 0;
            for(int i = 0; i< num; i++){
                if(sumOfDif == 0) {
                    if(!longerArray[i].equals(shorterArray[i])){
                        sumOfDif++;
                        if(!longerArray[i+1].equals(shorterArray[i])){
                            sumOfDif++;
                        }
                    }
                } else{
                    if(!longerArray[i+1].equals(shorterArray[i])){
                        sumOfDif++;
                    }
                    if(sumOfDif >= 2) break;
                }
            }
            // if(sumOfDif == 0) return true;
            // if(sumOfDif == 1 && longerArray[num].equals(shorterArray[num-1])) return true;
            // else return false;
            if(sumOfDif >= 2) return false;
            else return true;
        } else return false;
    }
}
