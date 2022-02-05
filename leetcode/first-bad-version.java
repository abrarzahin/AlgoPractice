
//Uses isBadVersion API
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
    // using binary search, so time: logN, space:1
        int start = 1;
        int end = n;
        while( start +1 < end){
            int mid = start + (end - start)/2;
          if(isBadVersion(mid)){
             end = mid;
           } 
            else {
               start = mid;
             }  
        }   
        if( isBadVersion(start)){
            return start;
        }   
        return end;
    }
}