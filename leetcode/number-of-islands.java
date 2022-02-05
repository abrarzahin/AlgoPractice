/*
Time complexity : O(M×N) where MM is the number of rows and NN is the number of columns.
Space complexity :O(min(M,N)) because in worst case where the grid is filled with lands, the size of queue can grow up to min(M,NM,N).
*/

class Solution {
    // Using DFS
    public int numIslands(char[][] grid) {

        // edge case 
        if( grid == null || grid.length == 0){
            return 0;
        }
        
        int nr = grid.length;
        int nc = grid[0].length;
        
        int num_islands = 0;
        // iterate through row and column
        for(int r = 0; r < nr; r++){
            for( int c = 0; c < nc; c++){
                if(grid[r][c] == '1'){
                    ++num_islands;
                    dfs(grid, r,c);
                }
            }
        }
        
        return num_islands;
        
    }
    
    public void dfs(char[][] grid, int r, int c){
        int nr = grid.length;
        int nc = grid[0].length;
        // edge cases
        if( r<0 || c<0 || r>= nr || c >= nc || grid[r][c] =='0'){
          return;  
        }
        // make it 0 and visit all neighbours
        grid[r][c] ='0';
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }
}
