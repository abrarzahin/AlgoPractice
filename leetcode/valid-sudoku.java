class Solution {
    /**Time complexity: O(N^2) because we need to traverse every position in the board, and each of the four check steps is an O(1)O(1) operation.

Space complexity: O(N^2) because in the worst-case scenario, if the board is full, we need a hash set each with size N to store all seen numbers for each of the N rows, N columns, and N boxes, respectively.
     * 
     */
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        
        for( int i=0; i <9; i++){
            for( int j=0; j<9; j++){
                
                char current_val = board[i][j];
                
                if(current_val != '.'){
                    if( !seen.add(current_val +"found in row"+i) ||
                      !seen.add(current_val +"found in column"+j) ||
                       !seen.add(current_val +"found in 
box"+i/3+"-"+j/3)
                      
                      )
                        
                        return false;
                }
                
                
            }
        }
        
        return true;
    }
}
