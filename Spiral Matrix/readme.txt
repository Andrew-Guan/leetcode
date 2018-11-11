method1:

1. We need to check array is null or not first, or it will lead to a nullexception.
For example:
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new ArrayList<Integer>();
        int m = matrix.length; // row number m
        int n = matrix[0].length; // col number n
        
        if(matrix.length == 0) return output;

It will get a null pointer exception. 
The following codes are correct:
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new ArrayList<Integer>();
        if(matrix.length == 0) return output;
        
        int m = matrix.length; // row number m
        int n = matrix[0].length; // col number n
