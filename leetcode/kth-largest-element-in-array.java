class Solution {
    public int findKthLargest(int[] nums, int k) {
     /*
     Time complexity : O(Nlogk).
Space complexity :O(k) to store the heap elements.
     */    
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for( int i: nums){
            minHeap.add(i);
            if( minHeap.size() > k){
                minHeap.remove();
            }
        }
        
        return minHeap.remove();
        
    }
}
