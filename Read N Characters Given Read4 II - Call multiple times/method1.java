/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    char[] tmpBuf = new char[4];
    int numBuf = 0;
    boolean checkBuf = false;
    public int read(char[] buf, int n) {
        int bufL = 0;
        if(checkBuf) {
            if(n> numBuf){
                for(int i = 0; i< numBuf; i++){
                    buf[i] = tmpBuf[i];
                }
                bufL = numBuf;
                numBuf = 0;
                checkBuf = false;
            } else if(n == numBuf){
                for(int i = 0; i< numBuf; i++){
                    buf[i] = tmpBuf[i];
                }
                int res = numBuf;
                numBuf = 0;
                checkBuf = false;
                return res;
            } else {
                for(int i = 0; i< n; i++){
                    buf[i] = tmpBuf[i];
                }
                for(int i = 0; i< numBuf - n; i++){
                    tmpBuf[i] = tmpBuf[i+n];
                }
                int res = n;
                numBuf = numBuf - n;
                checkBuf = true;
                return res;
            }
        }
            char[] tmp = new char[4];
            int idx = 0; // for buf
            int count = 0; // count the number of characters 
            boolean end = false;
            while(idx < n -bufL && !end){
                count = 0;
                count = read4(tmp);
                if(count <4 ) end = true;
                int length = Math.min(n-bufL-idx, count);
                for(int i = 0; i<length; i++){
                    buf[bufL+idx + i] = tmp[i];
                }
                if(count > n-bufL-idx ){
                    for(int i = 0; i< count - (n-bufL-idx); i++){
                        tmpBuf[i] = tmp[i+(n-bufL-idx)];
                        numBuf++;
                        checkBuf = true;
                    }
                }
                idx += length;
            }
            return idx + bufL;
        
    } 
}
