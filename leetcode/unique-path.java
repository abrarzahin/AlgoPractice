class Solution {
    /**Time complexity: O(N×M).

Space complexity: O(N×M). */
    public int uniquePaths(int m, int n) {   
        if( m==0 || n==0){
            return 0;
        }
        // dp array
        int [][] numberOfPaths= new int[m][n];
        // set all row place to 1 initially
        for( int i=0; i < m; i++){
            numberOfPaths[i][0]=1;
        }
        // set all column place to 1 initially
        for( int j=0; j<n;j++){
            numberOfPaths[0][j]=1;
        }
        // iterate through
        for( int i=1; i<m;i++){
            for( int j=1; j< n;j++){
                // update current value to the value of its top + left path
                numberOfPaths[i][j]= numberOfPaths[i-1][j] + numberOfPaths[i][j-1];
            }
        }
        
        return numberOfPaths[m-1][n-1];
    }
}