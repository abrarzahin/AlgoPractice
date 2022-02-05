

class Solution {
    /*
Time complexity :O(n+m)
Space complexity :O(1)
*/
    public boolean searchMatrix(int[][] matrix, int target) {
        if( matrix == null || matrix.length ==0) return false;
        int m = matrix.length, n= matrix[0].length;
        // set cur row col to the right top corner
        int curRow = 0, curCol= n-1;
        
        // 
        while( curRow < m && curCol >=0 ){
            if(matrix[curRow][curCol] == target) return true;
            
            else if(matrix[curRow][curCol]> target)
                 {
                  curCol--;
                 }
            else {
                curRow++;
                 } 
            
        }
        return false;
    }
}
