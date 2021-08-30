class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
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
