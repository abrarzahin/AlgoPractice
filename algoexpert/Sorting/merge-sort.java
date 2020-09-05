import java.util.*;

class Program {
  public static int[] mergeSort(int[] array) {
    if(array.length <=1){
			return array;
		}
		int[] auxiliaryArray = array.clone();
		mergeSort(array, 0, array.length-1, auxiliaryArray);
		return array;
  }
	
	public static void mergeSort(int[] mainArray, int startIdx, 
															 
int endIdx, int[] auxiliaryArray){
		if( startIdx == endIdx){
			return;
		}
		
		int middleIdx = (startIdx+endIdx)/2;
		mergeSort(auxiliaryArray, startIdx, middleIdx, 
mainArray);
		mergeSort(auxiliaryArray, middleIdx+1, endIdx, 
mainArray);
		doMerge(mainArray, startIdx, middleIdx, endIdx, 
auxiliaryArray);
		
	}
	
	public static void doMerge(
	int[] mainArray, int startIdx, int middleIdx, int endIdx, int[] 
auxiliaryArray){
		int k = startIdx;
		int i = startIdx;
		int j = middleIdx+1;
		
		while( i <= middleIdx && j <= endIdx){
			if( auxiliaryArray[i] <= auxiliaryArray[j]){
				mainArray[k++]= auxiliaryArray[i++];
			} else {
				mainArray[k++]= auxiliaryArray[j++];
			}
		}
		
		while( i <= middleIdx){
			mainArray[k++]= auxiliaryArray[i++];
		}
		
		while( j <= endIdx){
			mainArray[k++] = auxiliaryArray[j++];
		}
	}
}

