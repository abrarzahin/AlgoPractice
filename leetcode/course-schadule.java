import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution{
  /* BFS approach, Time Complexity: O(V + E) where V represents the number of vertices and E represents the number of edges.
Space Complexity: O(V + E), V- vertices in Queue, E adj lists in map
*/
    int n;
    int[] indegree;

    public boolean canFinish(int numCourses, int[][] prerequisites){

      n = numCourses;
      indegree = new int[n];
      // hashmap to create adjcency map
      Map<Integer, List<Integer>> adj = new HashMap<>();

      // create adj map where key is prereq 
      for( int[] pr : prerequisites){
        List<Integer> l = adj.getOrDefault(pr[1], new ArrayList<>());
        l.add(pr[0]);
        // count prereq of each course where index is the course
        indegree[pr[0]]++;
        adj.put(pr[1], l);

      }

      Queue<Integer> q = new LinkeList<>();
      int count = 0;

      for( int i=0; i < indegree.length;i++){
        // if index/course dosent have prereq put it in the queue
          if( indegree[i]==0) q.add(i);
      }


      while(!q.isEmpty()){

        int curr = q.poll();

        if( indegree[curr]==0) count++;

        if( !adj.containsKey(curr)) continue;
          // visit each of that courses post req
        for( int nei : adj.get(curr)){
          // and substract 1 from them since this course will be possible
            indegree[nei]--;
          // after substracting if theres more course that 
          //become 0 indegree means no prereq then add to the queue
            if( indegree[nei]==0) q.add(nei);
        }

      }
      // if succesfully taken courses is eq to number of courses 
      return count == n;
    }
}