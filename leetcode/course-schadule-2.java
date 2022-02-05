class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
/* BFS approach, Time Complexity: O(V + E) where V represents the number of vertices and E represents the number of edges.
Space Complexity: O(V + E), V- vertices in Queue, E adj lists in map
*/
    boolean isPossible = true;
    Map<Integer, List<Integer>> adjList = new HashMap<Integer, 
List<Integer>>();
    int[] indegree = new int[numCourses];
    // to hold the 
    int[] topologicalOrder = new int[numCourses];

    // Create the adjacency list representation of the graph
    for (int i = 0; i < prerequisites.length; i++) {
      int end = prerequisites[i][0];
      int start = prerequisites[i][1];
      List<Integer> lst = adjList.getOrDefault(start, new 
ArrayList<Integer>());
      lst.add(end);
      adjList.put(start, lst);

      // Record in-degree of each vertex
      indegree[end] += 1;
    }

    // Add all vertices with 0 in-degree to the queue
    Queue<Integer> q = new LinkedList<Integer>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    int i = 0;
    // Process until the Q becomes empty
    while (!q.isEmpty()) {
      int node = q.remove();
      topologicalOrder[i++] = node;

      // Reduce the in-degree of each neighbor by 1
      if (adjList.containsKey(node)) {
        for (Integer neighbor : adjList.get(node)) {
          indegree[neighbor]--;

          // If in-degree of a neighbor becomes 0, add it to the Q
          if (indegree[neighbor] == 0) {
            q.add(neighbor);
          }
        }
      }
    }

    // Check to see if topological sort is possible or not.
    if (i == numCourses) {
      return topologicalOrder;
    }

    return new int[0];
  }
}
