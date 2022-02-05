/*
Time Complexity:O(∣E∣log ∣V∣/∣E∣) where |E| is the number of edges (flights) in the input.

 Space Complexity: O(∣V∣+∣E∣) where |V| is the number of airports and E  is the number of flights.
*/
public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();

        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }

        dfs("JFK", flights, res);
        return res;
    }

    public void dfs(String dep, Map<String, PriorityQueue<String>> 
flights, LinkedList<String> res) {
        PriorityQueue<String> arrivals = flights.get(dep);
        // do dfs for each destination of jfk
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), flights, res);
        }
        // start adding from the last destination after all dfs call
        res.addFirst(dep);
    }
}

