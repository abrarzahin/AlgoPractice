class solution{
    // using maxHeap, 
    /*
    Time complexity:O(N⋅logk)
Adding to/removing from the heap (or priority queue) only takes O(logk) time when the size of the heap is capped at kk elements.
Space complexity: O(k)
The heap (or priority queue) will contain at most kk elements.
    */
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] 
    * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }

}

