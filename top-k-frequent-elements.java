class Solution {
     public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length)
            return nums;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums)
            // 1. use single Map operation here - faster then get/put 
operation pair
            counts.compute(num, (n, c) -> c == null ? 1 : c + 1);
        int[] result = new int[k];
        int pos = 0;
        // 2. if there are only k elements found, no need move it 
through the heap
        // counts.size() < k can't occur per solution definition
        if (counts.size() == k) {
            for (Integer key : counts.keySet())
                result[pos++] = key;
            return result;
        }
        // 3. heap should contain pairs of (number,count) - naturally 
these are map entries
        // we will avoid map polling (count = map.get(number) - bad 
performance) with this approach
        // 4. we need minHeap with capacity of k + 1 to keep k biggest 
entries
        // let's specify capacity to avoid internal array reallocation 
(bad performance)
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new 
PriorityQueue<>(
                k + 1,
                (c1, c2) -> c1.getValue() - c2.getValue()
        );
        for (Map.Entry<Integer, Integer> count : counts.entrySet()) {
            heap.add(count);
            // 5. populate heap only with maximum of k + 1 entries
            // if there are k + 1 entries, min entry should be deleted 
(polled)
            if (heap.size() > k)
                heap.poll();
        }
		// 6. we need to just iterate through the heap with no 
order guarantee
		// polling will sort the result - bad performance
        for (Map.Entry<Integer, Integer> entry : heap)
            result[pos++] = entry.getKey();
        return result;
    }
}
