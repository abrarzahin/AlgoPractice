
class Solution {
/*
Time complexity : O(n)O(n). Single loop upto nn.
Space complexity : O(n)O(n). dpdp array of size nn is used.
*/
    public int climbStairs(int n) {
        if( n <=1){
            return 1;
        } 
        // DP
        int [] ways = new int[n+1];
        ways[0]=1;
        ways[1]=1;
        for ( int i=2; i <=n;i++){
            ways[i]= ways[i-2]+ ways[i-1];
        }    
        return ways[n];
    }
}