public class solution{
    /**Time complexity: O(n). We traverse the list containing nn elements only once. Each lookup in the table costs only O(1)O(1) time.

Space complexity: O(n). The extra space required depends on the number of items stored in the hash table, which stores at most nn elements. */
    public int [] twoSum(int[] nums, int target){
        int [] result= new int[2];

        Map<Integer, Integer> visited= new Hashmap<>();

        for(int i =0; i < nums.length; i++){
            if(visited.containsKey(target- nums[i])){
                result[0]= visited.get(target- nums[i]);
                result[1]=i;
                return result;

            }
            visited.put(nums[i],i);

        }
        return result;

    }
}

