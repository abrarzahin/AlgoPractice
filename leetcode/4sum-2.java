class Solution {
  /*
  Time Complexity: O(N^2).We have 2 nested loops to count sums, and another 2 nested loops to find complements.

Space Complexity: O(N^2) for the hashmap. There could be up to  O(N^2) distinct a + b keys.
  */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    Map<Integer, Integer> map = new HashMap<>();
     for(int i=0; i<C.length; i++) {
        for(int j=0; j<D.length; j++) {
            
            int sum = C[i]+D[j];
            map.put(sum, map.getOrDefault(sum, 0)+1);
            
        }
      }
      int res = 0;
      for(int i=0; i<A.length; i++) {
        for(int j=0; j<B.length; j++) {
            
            res= res+ map.getOrDefault(-1*(A[i]+B[j]), 0);     
          }
       }
       return res;
    }
}
