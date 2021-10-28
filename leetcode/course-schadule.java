import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution{

    int n;
    int[] indegree;

    public boolean canFinish(int numCourses, int[][] prerequisites){

      n = numCourses;
      indegree = new int[n];

      Map<Integer, List<Integer>> adj = new HashMap<>();

      for( int[] pr : prerequisites){

        List<Integer> l = adj.getOrDefault(pr[1], new ArrayList<>());

        l.add(pr[0]);
        indegree[pr[0]]++;
        adj.put(pr[1], l);

      }

      Queue<Integer> q = new LinkeList<>();
      int count = 0;

      for( int i=0; i < indegree.length;i++){
          if( indegree[i]==0) q.add(i);
      }


      while(!q.isEmpty()){

        int curr = q.poll();

        if( indegree[curr]==0) count++;

        if( !adj.containsKey(curr)) continue;

        for( int nei : adj.get(curr)){
            indegree[nei]--;

            if( indegree[nei]==0) q.add(nei);
        }

      }

      return count == n;
    }




}