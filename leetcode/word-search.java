class Solution {
    /**Time Complexity: O(N⋅3^l) where NN is the number of cells in the board and LL is the length of the word to be matched.
     * Space Complexity: O(L) where LL is the length of the word to be matched.
     */
    public boolean exist(char[][] board, String word) {
        
        int m = board.length, n = board[0].length;
        
        for( int i =0; i < m ; i++){
            for( int j =0; j < n ; j++){
                
                if( word.charAt(0) == board[i][j] && helper(board, i, j, word, 0)){
                    return true;
                }
                
            }
        }
        
        return false;
    }
    
    private boolean helper( char [][] board, int row, int col, 
                           String word, int count){
        
        if( count == word.length()) return true;
        
        if( row < 0 || col < 0 || row >= board.length ||
          col >= board[0].length || board[row][col] != word.charAt(count)){ 
            return false;
        }
        
       
        char temp = board[row][col];
        board[row][col] = ' ';
        
        
        boolean found = helper(board, row+1, col, word, count+1) ||
          helper(board, row-1, col, word, count+1) ||
          helper(board, row, col-1, word, count+1) ||
          helper(board, row, col+1, word, count+1);
        
        board[row][col] = temp;
        
        return found;
        
        
        
    }
    
    
}