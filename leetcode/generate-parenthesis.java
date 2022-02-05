class Solution {
    /* backtrack, time: O(4^n/root N) Each valid sequence has at most n steps during the backtracking procedure. space: O(4^n/root N).
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtrack(result,"",0,0,n);
        return result;
        
    }
    public void backtrack(List<String> result, String current_str, int 
open, int close, int max){
        if( current_str.length() == max*2){
            result.add(current_str);
            return;
        }
        if(open<max){
            backtrack(result,current_str+"(", open+1, close, max);   
        }
        if( close<open){
            backtrack(result, current_str+")", open, close+1, max);
        }
    }
    
}

