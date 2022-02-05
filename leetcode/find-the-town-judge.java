class Solution {
    /*
    Time Complexity : O(E)

Same as above. We still need to loop through the EE edges in trust, and the argument about the relationship between NN and EE still applies.

Space Complexity : O(N)

Same as above. We're still allocating an array of length NN.
    */
    public int findJudge(int N, int[][] trust) {
        
        int[] count = new int[N+1];
        
        for(int[] t : trust){
            count[t[0]]--;
            count[t[1]]++;
        }
        
        for( int i=1; i <= N; i++){
            if( count[i] == N-1) return i;
        }
          
        return -1;
        
    }
}
