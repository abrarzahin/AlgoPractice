class Solution {
	// bit manupulation, O(1), O(1)
    public int getSum(int a, int b) {  
    	if (a == 0) return b;
        if (b == 0) return a;
    	while (b != 0) {
	 	int carry = a & b;
	 	a = a ^ b; // a xor b
	 	b = carry << 1;
	   }
	
	  return a;
        
    }
}