class Solution {/*Time complexity :O(nlog(n))+O(mlog(n)). Where n is the length of products and m is the length of the search word. 
    space: O(N)
    */
    public List<List<String>> suggestedProducts(String[] products, 
String searchWord) {
        List<List<String>> result = new ArrayList<>();
        // useing maxheap for iexological order 
        PriorityQueue<String> heap = new 
PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 1; i <= searchWord.length(); i++) {
            String t = searchWord.substring(0, i);
            for (String product: products) {
                if (product.startsWith(t)) {
                    heap.offer(product);
                }
                if (heap.size() > 3) {
                    heap.poll();
                }
            }
            
            LinkedList<String> temp = new LinkedList<>();
            while (!heap.isEmpty()) {
                temp.addFirst(heap.poll());
            }
            result.add(temp);
        }
        return result;
    }
}
