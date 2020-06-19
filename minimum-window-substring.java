class Solution {
    public String minWindow(String s, String t) {
       if( s == null || s.length() == 0)
           return "";
        
        int lo=0, hi=0;
        int minLen = Integer.MAX_VALUE;
        int minStart= -1, minEnd = -1;
        
        int count =0;
        
        
        int[] map = new int[128];
        
        for( char c : t.toCharArray()){
            map[c]++;
        }
        
        
        for( hi=0; hi< s.length(); hi++){
            
            if( map[s.charAt(hi)] >0){
                count ++;
               }
            
            map[s.charAt(hi)]--;
            
              if( count == t.length()){
                   while(lo<hi && map[s.charAt(lo)] <0){
                     map[s.charAt(lo)]++;
                     lo++;
                   }
                  
                  if( hi - lo +1 < minLen){
                      minLen = hi - lo +1;
                      
                      minStart = lo;
                      minEnd = hi+1;
                  }
                  
                  map[s.charAt(lo)]++;
                  count--;
                  lo++;
                
                
                
               }
        
        
        }
        
        return (minStart == -1) ? "" : s.substring(minStart, minEnd);
        
    }
}