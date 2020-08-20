import java.util.*;

class Program {
  public static int numberOfBinaryTreeTopologies(int n) {
    List<Integer> cache = new ArrayList<Integer>();
		
		cache.add(1);
		
		for( int m = 1 ; m < n+1; m++){
			int numberOfTrees = 0;
			for(int left = 0; left < m; left++){
				int right = m-1-left;
				int numberOfLeft = cache.get(left);
				int numberOfRight = cache.get(right);
				
				numberOfTrees += numberOfLeft * 
numberOfRight;
			}
			
			cache.add(numberOfTrees);
		}
		
		return cache.get(n);
  }
}

