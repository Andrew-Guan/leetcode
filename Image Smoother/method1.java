class Solution {
    public int[][] imageSmoother(int[][] M) {
        if( M == null) return M;
        int row = M.length;
        if(row == 0) return M;
        int col = M[0].length;
        if(col == 0) return M;
        int[][] res = new int[row][col];
        
        int num = 0;
        int sum = 0;
        int avg = 0;
        for(int i = 0 ; i < row; i++){
            for(int j = 0; j < col; j++){
                num++;
                sum += M[i][j];
                if(j-1>= 0){
                    num++;
                    sum += M[i][j-1];
                    if(i-1>= 0){
                        num++;
                        sum += M[i-1][j-1]; 
                    }
                    if(i+1 < row){
                        num++;
                        sum += M[i+1][j-1];
                    }
                }
                if(j+1 < col){
                    num++;
                    sum += M[i][j+1];
                    if(i-1>= 0){
                        num++;
                        sum += M[i-1][j+1]; 
                    }
                    if(i+1 < row){
                        num++;
                        sum += M[i+1][j+1];
                    }
                }
                if(i-1>= 0){
                    num++;
                    sum += M[i-1][j]; 
                }
                if(i+1< row){
                    num++;
                    sum += M[i+1][j]; 
                }
                avg = sum/num;
                res[i][j] = avg;
                
                num = 0;
                sum = 0;
                avg = 0;
            }
        }
        return res;
    }
}
