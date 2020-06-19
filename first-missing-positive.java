class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length;
        boolean oneExist= false;
        
        
        // check if 1 exist
        for( int d : nums){
            if( d==1) oneExist= true;
        }
        
        
        // return 1 if 1 does not exist
        if(!oneExist) return 1;
        
        
        
        // valid number check and set 1 for neg numbes
        for( int i=0; i < n ; i++){
            if( nums[i] <=0 || nums[i] >n)
                nums[i]=1;
        }
        
        
        //go through
        for( int i=0; i < n; i++){
            
            
            //get index
            int index = Math.abs(nums[i]);
            
            
            // invalidate the value of an index when its found
            
            // if last then do first index
            if(index == n){
                nums[0] = -1 * Math.abs(nums[0]);
            }
            else {
                // otherwise do the exact index
                nums[index] = -1* Math.abs(nums[index]);
            }
            
        }
        
        
        // return index of any positive value remain
        for( int i=1; i < n ; i++){
            if(nums[i] > 0) return i;
        }
        
        
        if( nums[0] > 0) return n;
        
        
        // return next if the array has all positive
        return n+1;
        
    }
}
