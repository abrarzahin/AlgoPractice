class Solution {
// using math, timeO( root N) and space : O(1)
    protected boolean isSquare(int n) {
      int sq = (int) Math.sqrt(n);
      return n == sq * sq;
    }
  
    public int numSquares(int n) {
      // four-square and three-square theorems.
      //4^k(8m+7)
      while (n % 4 == 0)
        n /= 4;
      if (n % 8 == 7)
        return 4;
  
      if (this.isSquare(n))
        return 1;
      // enumeration to check if the number can be decomposed into sum of two squares.
      for (int i = 1; i * i <= n; ++i) {
        if (this.isSquare(n - i * i))
          return 2;
      }
      // bottom case of three-square theorem.
      return 3;
    }
  }