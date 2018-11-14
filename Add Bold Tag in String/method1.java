class Solution {
    public String addBoldTag(String s, String[] dict) {
        // get the length of string and create a new string[] to record the coverage. 
        // check each string in the dict and update the coverage.
        // based on the coverage, create a correct output. 
        // first
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
                if(s.contains(dict[i])){
                    int pos = s.indexOf(dict[i], currentPos);
                    int lenghtOfOneElement = dict[i].length();
                    for(int j = 0; j < lengthOfOneElement){
                        coverrage[pos + j] = 0;
                    }
                }
            }    
        }
        
        int length = dict.length;
        return String.valueOf(pos);
    }
}
