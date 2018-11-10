class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length; // row number m
        int n = matrix[0].length; // col number n
        int numTotal = m*n; 
        List<Integer> output = new ArrayList<Integer>();
        
        int rowIndexS = 0;  //row start
        int rowIndexE = m - 1; // row end
        int colIndexS = 0;  //col start
        int colIndexE = n - 1; // col end
        
        int counter = 0;
        
        if(matrix.length == 0) return output;
        if(matrix.length==1){
            for(int i=0;i<matrix[0].length;i++)
                output.add(matrix[0][i]);
            return output;
        }
        else if(matrix[0].length==1){
            for(int i=0;i<matrix.length;i++)
                output.add(matrix[i][0]);
            return output;
        }
        while (rowIndexS <= rowIndexE && colIndexS <= colIndexE){
            for(int i = colIndexS; i<= colIndexE; i++){
                //if(counter == numTotal) break;
                output.add(matrix[rowIndexS][i]);
                counter++;
            }
            if(counter == numTotal) break;
            for(int i = rowIndexS + 1; i <= rowIndexE; i++){
                //if(counter == numTotal) break;
                output.add(matrix[i][colIndexE]);
                counter++;
            }
            if(counter == numTotal) break;
            for(int i = colIndexE - 1; i >= colIndexS; i--){
                //if(counter == numTotal) break;
                output.add(matrix[rowIndexE][i]);
                counter++;
            }
            if(counter == numTotal) break;
            for(int i = rowIndexE - 1; i>= rowIndexS + 1; i--){
                //if(counter == numTotal) break;
                output.add(matrix[i][colIndexS]);
                counter++;
            }
            if(counter == numTotal) break;
            rowIndexS++;
            rowIndexE--;
            colIndexS++;
            colIndexE--;
        }
       
        return output;
    }
    

}