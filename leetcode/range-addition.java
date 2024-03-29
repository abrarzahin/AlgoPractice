class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
    // time: O(K+N), space: O(K)    
        int[] res = new int[length];
        for( int i=0; i < updates.length; i++){
            int st  = updates[i][0];
            int end = updates[i][1];
            int inc = updates[i][2];
            // 
            res[st] += inc;   
            if( end+1 < length){
                res[end+1] -= inc;
            }
            
        }
        int sum = 0;
        for( int i=0; i < length; i++){
            sum += res[i];  
            res[i] = sum;
        }
        
        return res;
    }
}
