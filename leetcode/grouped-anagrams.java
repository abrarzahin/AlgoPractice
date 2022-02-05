class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      /*
      Time Complexity:O(NKlogK), where NN is the length of strs, and K is the maximum length of a string in strs. The outer loop has complexity O(N)as we iterate through each string. Then, we sort each string in O(KlogK) time.
    Space Complexity: O(NK), the total information content stored in ans.
      */   
        List<List<String>> grouped = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for( String curr : strs){
            char[] ch = curr.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            if( !map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(curr);
        }
        grouped.addAll(map.values());
        return grouped;
        
    }
}
