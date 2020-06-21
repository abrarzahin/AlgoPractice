class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        return wordBreakHelper(s, wordDict, new HashMap<String, List<String>>());
        
    }
    
    
    public List<String> wordBreakHelper( String s, List<String> wordDict, Map<String, List<String>> memo){
        
        if(memo.containsKey(s)){
            return memo.get(s); 
        }
        
        List<String> results = new ArrayList<>();
        
        if( s.length() == 0){
            // base case check  
            results.add("");
            return results;
        }
        
        // add the first word and also the substrings after that using reccursion
        for( String word : wordDict){
            if(s.startsWith(word)){
                String sub= s.substring(word.length());
                List<String> subStrings = wordBreakHelper(sub, wordDict, memo);
                
                for( String subString : subStrings){
                    String optionalSpace = subString.isEmpty() ? "" : " ";
                    results.add(word + optionalSpace + subString);
                }
            }
        }
        
        memo.put(s, results);
        return results;
        
        
        
        
    }
}