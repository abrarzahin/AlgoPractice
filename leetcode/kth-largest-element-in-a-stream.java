class KthLargest {
    //Given NN as the length of nums and MM as the number of calls to add(),
    //O(N⋅log(N)+M⋅log(k)) , space O(N)
    private static int k;
    private PriorityQueue<Integer> heap;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        for (int num: nums) {
            heap.offer(num);
        }
        while (heap.size() > k) {
            heap.poll();
        }
    }
    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }

        return heap.peek();
    }
}


