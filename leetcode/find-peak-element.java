class Solution {
    public int findPeakElement(int[] nums) {
        // binary search
        /*
        Time complexity : O(log2N) We reduce the search space in half at every step. Thus, the total search space will be consumed in log_2(n) steps.
        Space:O(1).
        */ 
        int left = 0;
        int right = nums.length -1;
        while( left < right){
            int mid = left+(right - left)/2;
            if( nums[mid] < nums[mid+1]){
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        return left; 
    }
}

