class Solution {
    // time: O(NlogN), space: O(logN) or N
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
        // sort by the first index
        Arrays.sort(intervals,(arr1,arr2)->Integer.compare(arr1[0], arr2[0]));
        // because we dont know the size of the output.
        List<int[]> output_arr = new ArrayList();

        //start with the first interval as current
        int[] current_interval = intervals[0];
        output_arr.add(current_interval);
        for(int[] interval : intervals){
            
            int current_begin = current_interval[0];
            int current_end = current_interval[1];
            int next_begin = interval[0];
            int next_end = interval[1];
            
            if( current_end >= next_begin){
                // update the end part
                current_interval[1] = Math.max(current_end, next_end);
            } else {
                // set this as current 
                current_interval = interval;
                output_arr.add(current_interval);
            }  
        }
        
        // convert back to array
        return output_arr.toArray(new int[output_arr.size()][]);
        
    }
}