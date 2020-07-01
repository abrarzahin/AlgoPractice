class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> grouped = new ArrayList<>();
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for( String curr : strs){
            char[] characters = curr.toCharArray();
            
            Arrays.sort(characters);
            
            String sorted = new String(characters);
            
            if( !map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            
            map.get(sorted).add(curr);
        }
        
        grouped.addAll(map.values());
        
        return grouped;
        
    }
}
