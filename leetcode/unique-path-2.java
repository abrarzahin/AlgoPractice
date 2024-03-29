class Solution {
    /**Time Complexity: O(M×N). The rectangular grid given to us is of size M \times NM×N and we process each cell just once.
    Space Complexity: O(1). We are utilizing the obstacleGrid as the DP array. Hence, no extra space. */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length ==0){
            return 0;
        }
        
        int height = obstacleGrid.length;
        int width= obstacleGrid[0].length;
        
        int[][] paths = new int[height][width];
        
        //first column
        
        for(int i =0; i < height; i++){
            
            if( obstacleGrid[i][0] != 1){
                paths[i][0] =1;
            }
            else {
                break;
            }
            
        }
        
        
        //first column
        
        for (int j=0; j< width; j++){
            if(obstacleGrid[0][j] !=1){
                paths[0][j]=1;
            }
            else {
                break;
            }
        }
        
        //for spaces not at frist row or first column
        
        for( int i=1; i< height; i++){
            for (int j=1; j< width;j++){
                if(obstacleGrid [i][j] !=1){
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];
                }
            }
        }
        
         return paths[height-1][width-1];
        
    }
}