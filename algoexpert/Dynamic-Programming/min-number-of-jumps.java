import java.util.*;

class Program {
  public static int minNumberOfJumps(int[] array) {
   
		if(array.length == 1){
			return 0;
		}
		
		int jumps =0;
		int maxReach = array[0];
		int steps = array[0];
		
		for( int i=1; i < array.length-1; i++){
			maxReach = Math.max(maxReach, i + array[i]);
			steps--;
			
			if( steps == 0){
				jumps++;
				steps = maxReach-i;
			}
		}
		
		return jumps+1;
  }
}

