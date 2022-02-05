class Solution {
    // time O(N), space O(N)
    public int trap(int[] height) {  
        int totalAmount = 0;
        // edge case
        if( height == null || height.length ==0){
            return totalAmount;
        }
        // left height DP
        int[] leftHighest = new int[height.length+1];
        leftHighest[0]=0;
        // calculate left height bar for each position based on dp
        for( int i=0; i < height.length; i++){
            leftHighest[i+1] = Math.max(leftHighest[i], height[i]);
        }
        int rightHighest = 0;
        // calculate rightHeight and
        // sum total when min of left height or right height is > current bar height
        for( int i = height.length-1; i >=0;i--){
            
            rightHighest = Math.max(height[i], rightHighest);
            totalAmount += Math.min(leftHighest[i], rightHighest)> 
height[i] 
                            
                            ? Math.min(leftHighest[i], 
rightHighest)-height[i] :0;
                                  
        }
         
        return totalAmount;
    }
}
