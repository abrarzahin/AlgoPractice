class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        
        // put into a treemap for sorted key
        for( int[] b : buildings){
            map.putIfAbsent(b[0], new ArrayList<>());
            map.putIfAbsent(b[1], new ArrayList<>());
            map.get(b[0]).add(b);
            map.get(b[1]).add(b);
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[2]-a[2]);
        List<List<Integer>> res = new ArrayList<>();
        
        // itarate through the key
        for( int a : map.keySet()){
            List<int[]> bs = map.get(a);
            
            // iterate through the value 
             for( int[] b : bs){
                 // if first value = key
                if(b[0] ==a){
                    maxHeap.offer(b);
                } else {
                    maxHeap.remove(b);
                }
             }
            
             // for the gap spaces in the ground
             if( maxHeap.size() ==0){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(a);
                tmp.add(0);
                res.add(tmp);
               }  else {

                        // otherwise record the max height with key index
                        int maxHeight = maxHeap.peek()[2];
                
                        if(res.size()==0 || 
                         res.get(res.size()-1).get(1) != maxHeight)                         {
                         List<Integer> tmp = new ArrayList<>();
                         tmp.add(a);
                         tmp.add(maxHeight);
                         res.add(tmp);
                        }
                   }
        }
        
        return res;
        
        
    }
}