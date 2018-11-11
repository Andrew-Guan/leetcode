class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        //s = "abaccc"; k = 2;
        LinkedList<String> distinctK = new LinkedList<String>(); // a list for each character
        LinkedList<Integer> lastIndexOfElements = new LinkedList<Integer>(); // a list for the numbers of each character
        if(s == null || s.equals("")) return 0;
        if(k < 1) return 0;
        
        String[] s_array = s.split("");
        int length = s_array.length;
        int distinctLength = 0;
        int max = 0;

        for(int i = 0; i < length; i++){
            if(!distinctK.contains(s_array[i])){
                if(distinctK.size() < k){
                    distinctK.add(s_array[i]);
                    lastIndexOfElements.add(i);

                    distinctLength++;
                } else{
                    
                    distinctK.removeFirst();
                    distinctK.add(s_array[i]);
                    lastIndexOfElements.add(i);
                    distinctLength = i - lastIndexOfElements.removeFirst();
                    
                }
                max = (distinctLength > max)? distinctLength:max;
            } else {
                int index = distinctK.indexOf(s_array[i]);
                distinctK.remove(index);
                distinctK.add(s_array[i]);
                
                lastIndexOfElements.remove(index);
                lastIndexOfElements.add(i);
                
                distinctLength++;
                max = (distinctLength > max)? distinctLength:max;
            }
        }
        
        
        return max;
    }
}
