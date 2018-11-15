/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        int idx = 0; // for buf
        int count = 0; // count the number of characters 
        boolean end = false;
        while(idx < n && !end){
            count = 0;
            count = read4(tmp);
            if(count <4 ) end = true;
            int length = Math.min(n-idx, count);
            for(int i = 0; i<length; i++){
                buf[idx + i] = tmp[i];
            }
            idx += length;
        }
        return Math.min(idx,n);
        //return count;
    } 
}
