class Solution {
    public int longestSubstring(String s, int k) {
        
        char[] str= s.toCharArray();
        
        return helper(str,0,s.length(),k);
    }
    
    
    private int helper(char[] str, int start, int end, int k){
        
        if(end-start < k) return 0;// no need to go for length shorter 
then k.
        
        int[] count = new int[26];
        
        for( int i=start; i < end; i++){
            int index = str[i]-'a';
            
            count[index]++;
        }
        
        
        for( int i=0; i < 26; i++){
            
            if( count[i] < k && count[i] > 0){// count[i]=0 --> i+'a' 
does not exist, thats why lower limit
                for( int j=start; j < end; j++){
                    if( str[j]==i+'a'){
                        int left = helper(str, start, j , k);
                        int right = helper(str, j+1, end, k);
                        return Math.max(left,right);
                    }
                }
            }
            
        }
        
        
        
        
        return end-start;
        
    }
}
