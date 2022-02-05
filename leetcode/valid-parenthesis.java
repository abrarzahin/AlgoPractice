class Solution {
    /**Time complexity : O(n) because we simply traverse the given string one character at a time and push and pop operations on a stack take O(1) time.
Space complexity : O(n) as we push all opening brackets onto the stack and in the worst case, we will end up pushing all the brackets onto the stack. e.g. ((((((((((.
 */
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<Character>();
        boolean isValid = false;
        for( int i=0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if( ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            } else {
                    
                    if( !stack.isEmpty() && 
isPairParenthesis(stack.peek(), ch)){
                        stack.pop();
                    } else {
                        return false;
                    }
            }
              
        }
        return stack.isEmpty();
        
    }
    private boolean isPairParenthesis( char c1, char c2){
        return ( c1 == '(' && c2 == ')'
               || c1 == '{' && c2 =='}'
                || c1 == '[' && c2 == ']'
               
               );
    }
}
