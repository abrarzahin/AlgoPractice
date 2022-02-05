
class Solution {
    /* time: O(n) Although the time complexity appears to be quadratic due to the while loop nested within the for loop, closer inspection reveals it to be linear. Because the while loop is reached only when currentNum marks the beginning of a sequence (i.e. currentNum-1 is not present in nums), the while loop can only run for n iterations throughout the entire runtime of the algorithm. This means that despite looking like O(n⋅n) complexity, the nested loops actually run in O(n+n)=O(n) time. All other computations occur in constant time, so the overall runtime is linear.
    space: O(n) hashset
    */
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> num_set = new HashSet<Integer>();
        
        for( int num : nums){
            num_set.add(num);
        }
        int longestStreak=0;
        for( int num : num_set){
           if( !num_set.contains(num-1)){
               int currentNum = num;
               int currentStreak =1;  
               while( num_set.contains(currentNum+1)){
                   currentNum += 1;
                   currentStreak += 1;
               } 
               longestStreak = Math.max(longestStreak, currentStreak);
           } 
        }
        return longestStreak;
        
        
    }
}