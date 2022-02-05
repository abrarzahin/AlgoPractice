class Solution {
    public int countBinarySubstrings(String s) {
        // dp array using grouping technique 
        //time:O(N) for one iteration,Space: O(N) for dp array
        int[] groups = new int[s.length()];
        int t = 0;
        // set first to 1
        groups[0] =1;
        
        for( int i=1; i < s.length(); i++){
            // if prev is not eq current then go to next index
            if(s.charAt(i-1) != s.charAt(i)){
                groups[++t] =1;
            } else {
                // otherwise increment the current index value
                groups[t]++;
            }
        }
        int ans =0;
        for( int i=1; i<=t; i++){
            // get the min of indecies from dp array value and add those
            ans += Math.min(groups[i-1], groups[i]);
        }
        return ans;
    }
}
