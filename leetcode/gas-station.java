class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
     // time: O(N), space: O(1)   
        int tank = 0;
        for( int i=0; i < gas.length; i++){   
            tank += gas[i] - cost[i];  
        }
         if( tank < 0)
                return -1; 
        int start =0;
        int accumulate = 0;
        for( int i =0; i < gas.length; i++){
            
            int curGain = gas[i] - cost[i];
            if( accumulate + curGain < 0){
                start = i+1;
                accumulate = 0;
            }
                else {
                    accumulate += curGain;
                }
        }
        return start;
        
    }
}
