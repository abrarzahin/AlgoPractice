import java.util.PriorityQueue;
class Solution{
    // time: O(NlogN)
    // space: O(N)
    public int maxEvents(int[][] events){
        // sort events by start date
        Arrays.sort(events, (a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int ans =0, i=0, n = events.length;
        for( int d=1; d <= 100000; d++){
            // add new events that can be attended on day d
            while(i < n && events[i][0] ==d){
                minHeap.add(events[i++][1]);
            }
            // remove events that are already closed
            while(!minHeap.isEmpty() && minHeap.peek() < d){
                minHeap.poll();
            }
            //use day d to attend to the event that closes earlier
            if(!minHeap.isEmpty()){
                ans++;
                minHeap.poll();
            }
        }
        return ans;      
    }
    
}
