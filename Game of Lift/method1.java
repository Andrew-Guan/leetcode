class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = 0;
        if(row>0) col = board[0].length;
        // check the empty exception
        int[][] res;
        if(row > 0 && col > 0) res = new int[row][col];
        else return;
        // traverse each node and update res.
        for(int i = 0; i< row; i++){
            for(int j = 0; j< col; j++){
                int sum = 0;
                if(i-1 >= 0) sum = sum + board[i-1][j];
                if(i+1 < row) sum = sum + board[i+1][j];
                if(j-1 >= 0) sum = sum + board[i][j-1];
                if(j+1 < col) sum = sum + board[i][j+1];
                if(i-1 >= 0 && j-1 >= 0) sum = sum + board[i-1][j-1];
                if(i-1 >= 0 && j+1 < col) sum = sum + board[i-1][j+1];
                if(i+1 < row && j-1 >= 0) sum = sum + board[i+1][j-1];
                if(i+1 < row && j+1 < col) sum = sum + board[i+1][j+1];
                if(board[i][j] == 0){
                    if(sum == 3) res[i][j] =1; else res[i][j] = 0;
                }else{
                    if(sum < 2) {
                        res[i][j] = 0;
                    }else if(sum ==2 || sum == 3){
                        res[i][j] = 1;
                    }else if(sum > 3){
                        res[i][j] = 0;
                    }else{
                        res[i][j] = board[i][j];
                    }
                }

                
            }
        }
        for(int i = 0; i< row; i++){
            for(int j = 0; j< col; j++){
                board[i][j] = res[i][j];
            }
        }
        return;
        
    }
}
