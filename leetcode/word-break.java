
/*
Time complexity : O(n^3) There are two nested loops, and substring computation at each iteration. 
Space complexity : O(n) Length of pp array is n+1n+1.
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        // dp array
        boolean[] isWordBreak = new boolean[s.length()+1];
        // set the first one to true
        isWordBreak[0] = true;
        
        
        for(int i=0; i <s.length()+1; i++){
            for(int j=0; j < i ;j++){
                if( !isWordBreak[j]){
                    continue;
                }
                
                if(wordDict.contains(s.substring(j,i))){
                    isWordBreak[i]=true;
                    break;
                }
            }
        }
        
        return isWordBreak[s.length()];
        
    }
}