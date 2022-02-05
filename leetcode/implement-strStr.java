class Solution {
    //O(mn) 
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() > haystack.length()) return -1;

        int len = haystack.length(), i = 0, j = 0, pos = 0;
        while(i < len && j < needle.length()) {
            if(haystack.charAt(i++) == needle.charAt(j)) {
                j++;
            } else {
                i = i - j;
                j = 0;
                pos = i;
            }
        }
        return j == needle.length()? pos : -1;
    }


    public int strStr(String haystack, String needle) {
        
        if(haystack == null || needle == null){
            return -1;
        }
        for( int i=0; i < haystack.length()-needle.length()+1;i++){
            int j;
            for( j=0; j < needle.length(); j++){  
                if( haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
                
            }
            
            if( j==needle.length()){
                return i;
            }
            
        }
        
        return -1;
        
    }
}
