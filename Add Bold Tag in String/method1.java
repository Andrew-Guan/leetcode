class Solution {
    public String addBoldTag(String s, String[] dict) {
        // 1.get the length of string and create a new string[] to record the coverage. 
        // 2.check each string in the dict and update the coverage.
        // 3.based on the coverage, create a correct output. 
        // first
        // s = "aaa"; dict = new String[]{"a"};
        // s = "abcdef"; dict = new String[]{"a","c", "e", "g"};
        int lengthOfString = s.length();
        int[] coverage = new int[lengthOfString];
        for(int i = 0; i< lengthOfString; i++){
            coverage[i] = 1;
        }
        // second
        int lengthOfDict = dict.length;
        // lengthOfDict = 1;
        // int pos = 0;
        for(int i = 0; i< lengthOfDict; i++){
            int currentPos = 0;
            while(currentPos < lengthOfString){
                if(s.substring(currentPos).contains(dict[i])){
                    int pos = s.indexOf(dict[i], currentPos);
                    int lengthOfOneElement = dict[i].length();
                    for(int j = 0; j < lengthOfOneElement; j++){
                        coverage[pos + j] = 0;
                    }
                    currentPos++;
                } else {
                    break;
                }
            }    
        }

        // third
        String boldHead = "<b>";
        String boldTail = "</b>";
        String[] sArray = s.split("");
        StringBuilder res = new StringBuilder();
        for(int i = 0; i< lengthOfString; i++){
            if(i == 0 && coverage[i] == 0){
                    res.append(boldHead);
            }

            if(i<lengthOfString -1 ){
                if(coverage[i] == 0 && coverage[i+1] == 1){
                    res.append(sArray[i]);
                    res.append(boldTail);
                } else if(coverage[i] == 1 && coverage[i+1] == 0) {
                    res.append(sArray[i]);
                    res.append(boldHead);
                } else {
                    res.append(sArray[i]);
                }  
            } else {
                res.append(sArray[i]);
            }
            
            if(i == lengthOfString -1 && coverage[i] == 0) {
                    res.append(boldTail);
            }
        }
        
        return res.toString();
        // return String.valueOf(coverage);  // int[] intArray = { 1, 2, 3, 4 ,5 }; String str = Arrays. toString(intArray)
        //return Arrays.toString(coverage);
        //return String.valueOf(s.indexOf("a", 2));
    }
}
