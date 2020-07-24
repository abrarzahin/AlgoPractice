class Solution {
    public int rob(int[] nums) {
        
         if(nums.length == 0){
        return 0;
    } else if(nums.length == 1){
        return nums[0];
    }

    int second = nums[0];
    int first = Math.max(nums[0],nums[1]);

    for( int i =2 ; i < nums.length; i++){
        int current = Math.max(first, second+nums[i]);

        second = first;
        first = current;
    }

    return first;

  }
        
    
}
