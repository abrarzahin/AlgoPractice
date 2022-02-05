class Solution{
/*
Time complexity :O(M⋅N).We're solving M⋅N subproblems. Solving each subproblem is an O(1) operation.
Space complexity :O(M⋅N).
We'e allocating a 2D array of size M \cdot NM⋅N to save the answers to subproblems.
*/
    public int longestCommonSubsequence(String text1, String text2){
        // a grid of 0's with text2's column length and text1's row length
        int[][] dpGrid = new int[text1.length()+1][text2.length()+1];
        // iterate through starting from last column
        for( int col = text2.length()-1; col >= 0; col--){
            // iterate through row starting last one
            for( int row = text1.length(); row >=0; row--){
                // if both of the chars are same then increase the dp by 1
                if( text1.charAt(row) == text2.charAt(col)){
                    dpGrid[row][col] = 1 + dpGrid[row+1][col+1];
                }
                // else take the max value of lower cell or the right cell
                else{
                    dpGrid[row][col] = Math.max(dpGrid[row+1][col], dpGrid[row][col+1]);
                }
                
            }
        }

        return dpGrid[0][0];

    }


}
