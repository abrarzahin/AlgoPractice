class Solution {// backtracking
    /*Time complexity: O(n⋅2^n)

As we can see in the diagram above, this approach does not generate any duplicate subsets. Thus, in the worst case (array consists of nn distinct elements), the total number of recursive function calls will be 2 ^ n.
 space: O(N).
    */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if( nums== null || nums.length ==0){
            return results;
        }
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        toFindAllSubsets(nums, results, subset, 0);
        return results;
        
    }
    
    private void toFindAllSubsets(int [] nums, List<List<Integer>> results, List<Integer> subset, int startIndex)
      {
        results.add(new ArrayList<>(subset));
        for( int i=startIndex; i < nums.length; i++){
            if( i != startIndex && nums[i]==nums[i-1]){
                continue;
            }
            subset.add(nums[i]);
            toFindAllSubsets(nums, results, subset, i+1);
            subset.remove(subset.size()-1);
        }
      }    
}