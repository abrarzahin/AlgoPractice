public class Solution {
    // you need to treat n as an unsigned value
    // time O(1), space O(1)
    public int hammingWeight(int n) {  
        int result =0;    
        while( n!= 0){       
            result += (n%2)&1;        
            n >>>=1;
        }    
        return result;
        
    }
}
