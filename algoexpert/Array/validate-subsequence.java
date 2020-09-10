import java.util.*;

class Program {
  public static boolean isValidSubsequence(List<Integer> array, 
List<Integer> sequence) {
    
		int seqIdx = 0;
		
		for( var value : array){
			
				if(seqIdx == sequence.size()){
					break;
				}
			
			if(sequence.get(seqIdx).equals(value)){
				seqIdx++;
			}
			
		}
		
		return seqIdx == sequence.size();
  }
}

