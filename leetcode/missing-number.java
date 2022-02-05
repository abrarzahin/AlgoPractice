class Solution {// using gauss formula, i= (n(n+1))/2;
    //time: O(N), space:O(1)
    public int missingNumber(int[] nums) {
        
        int expectedSum = nums.length*(nums.length+1)/2;
        
        int actualSum = 0;
        
        for(int num : nums) actualSum += num;
        
        return expectedSum - actualSum;
        
    }
}

// also using hashset

class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }
}
