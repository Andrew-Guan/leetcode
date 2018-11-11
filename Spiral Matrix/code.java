class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new ArrayList<Integer>();
        if(matrix.length == 0) return output;
        
        int m = matrix.length; // row number m
        int n = matrix[0].length; // col number n
        int numTotal = m*n; 
        
        int rowIndexS = 0;  //row start
        int rowIndexE = m - 1; // row end
        int colIndexS = 0;  //col start
        int colIndexE = n - 1; // col end
        int counter = 0;

        while (rowIndexS <= rowIndexE && colIndexS <= colIndexE){
            for(int i = colIndexS; i<= colIndexE; i++){
                if(counter == numTotal) break;
                output.add(matrix[rowIndexS][i]);
                counter++;
            }
            for(int i = rowIndexS + 1; i <= rowIndexE; i++){
                if(counter == numTotal) break;
                output.add(matrix[i][colIndexE]);
                counter++;
            }
            for(int i = colIndexE - 1; i >= colIndexS; i--){
                if(counter == numTotal) break;
                output.add(matrix[rowIndexE][i]);
                counter++;
            }
            for(int i = rowIndexE - 1; i>= rowIndexS + 1; i--){
                if(counter == numTotal) break;
                output.add(matrix[i][colIndexS]);
                counter++;
            }
            rowIndexS++;
            rowIndexE--;
            colIndexS++;
            colIndexE--;
        }
       
        return output;
    }
    

}
