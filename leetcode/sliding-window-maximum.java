class Solution {// Deque
    /*Time complexity : O(N), since each element is processed exactly twice - it's index added and then removed from the deque.
Space complexity : O(N), since O(N−k+1) is used for an output array and O(k) for a deque.
    */
    public int[] maxSlidingWindow(int[] nums, int k) {   
        if( nums == null || nums.length ==0 || k > nums.length){
            return new int[0];
        }  
        int [] res = new int[nums.length - k +1];  
        // index dq
        Deque<Integer> dq = new ArrayDeque<>();  
        int i=0;  
        while(i < nums.length){
            
            // remove numbers out of range k
            if( !dq.isEmpty() && dq.peekFirst() == i-k){
                dq.pollFirst();
            }     
            // remove smaller numbers in k range 
            while( !dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }      
            // dq contains index and res contains content
            dq.offerLast(i);
            
            if( i >= k-1){
                res[ i - k +1] = nums[dq.peekFirst()];
            }     
            i++;
        } 
        return res;
        
        
        
    }
}