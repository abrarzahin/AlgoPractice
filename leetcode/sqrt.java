class Solution {
    public int mySqrt(int x) {
        // binary search O(logN), O(1)
        long start = 0;
        long end =x;
        while( start +1 < end){
            long mid= start + (end-start)/2;
            if( mid * mid ==x){
                return (int)mid;
            }
            else if(mid * mid < x){
                start = mid;
            }
            
            else {
                end = mid;
            }
        }
        if( end * end == x){
            return (int)end;
        }
        return (int)start;
    }
}