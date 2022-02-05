class Solution {
    public int[] plusOne(int[] digits) {
    // time =O(N), space= O(N)
    /*Although we perform the operation in-place (i.e. on the input list itself), in the worst scenario, we would need to allocate an intermediate space to hold the result, which contains the N+1 elements. Hence the overall space complexity of the algorithm is O(N).*/ 
        int n = digits.length;
        for( int i=n-1; i >=0; i--){
            if(digits[i] <9){
                digits[i]++;
                return digits;
            }
            
            digits[i]=0;
        }
        int[] new_num= new int[n+1];
        new_num[0]=1;
        return new_num;
        
    }
}
