class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int max = amount+1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, max);
        dp[0]=0;
        for( int i = 1; i<= amount; i++){
            for(int j=0; j < coins.length; j++){
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
                else {
                    break;
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
        
    }
    /*
    Time complexity : O(S*n)O(S∗n). On each step the algorithm finds the next F(i)F(i) in nn iterations, where 1\leq i \leq S1≤i≤S. Therefore in total the iterations are S*nS∗n.
Space complexity : O(S)O(S). We use extra space for the memoization table.
    */
}
