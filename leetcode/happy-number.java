class Solution {
    /*
    Time complexity :O(logn). Builds on the analysis for the previous approach, except this time we need to analyse how much extra work is done by keeping track of two places instead of one, and how many times they'll need to go around the cycle before meeting.
    Space: O(N) or O(1)
    */
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while( n != 1){
            int current = n;
            int sum = 0;
            while( current != 0){
                sum += (current % 10) * (current % 10);
                current /= 10;
            }
            if( seen.contains(sum)){
                return false;
            }
            seen.add(sum);
            n=sum;
        }
        return true;
        
    }
}