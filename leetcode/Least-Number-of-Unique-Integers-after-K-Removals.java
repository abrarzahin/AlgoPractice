class Solution {
    //Time: O(nlogn), space: O(n).
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // count using map
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr){
            count.put(a, count.getOrDefault(a,0)+1);
        }
        // less occurance on the top using minheap
        PriorityQueue<Integer> pq = new 
PriorityQueue<>(Comparator.comparing(count::get));
        pq.addAll(count.keySet());
        // remove until k is positive
        while (k > 0)
            k -= count.get(pq.poll());
        //remaining should be the size 
        return k < 0 ? pq.size() + 1 : pq.size();
        
    }
}
