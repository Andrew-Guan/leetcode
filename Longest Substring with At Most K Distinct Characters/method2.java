class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] chrFreq = new int[256]; // including ASCII and extended ASCII
        int l = 0;
        int max = 0;
        int num = 0;
        if(k ==0)  return 0; // this line is not necessary. 
        for(int i= 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            chrFreq[currentChar]++;
            if(chrFreq[currentChar] == 1) num++;
            if(num > k) {
                while(chrFreq[s.charAt(l)] > 1){
                    chrFreq[s.charAt(l)]--;
                    l++;
                }

                chrFreq[s.charAt(l)]--;
                l++;
                num--;
            }
            max = Math.max(max, i - l + 1);
        }
        return max;
    }
}
