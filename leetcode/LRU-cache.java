class LRUCache {
    /*
Time complexity :O(1) both for put and get.
Space complexity :O(capacity) since the space is used only for a hashmap and double linked list with at most capacity + 1 elements.
    */
    // create doubly linked list class
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
    }
    
    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer, Node> node_map;
    int cache_capacity;
    public LRUCache(int capacity) {
        node_map = new HashMap(capacity);
        this.cache_capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    // add node to the head 
    // to make it first accessable 
    public void add(Node node){
        
        Node head_next = head.next;
        head.next = node;
        node.prev = head;
        
        node.next = head_next;
        head_next.prev = node;
        
    }
    
    // remove node from its place
    public void remove(Node node){
        
        // capture the nodes next and prev node
        Node next_node = node.next;
        Node prev_node = node.prev;
        // connect the prev and next node ignoring the node itself
        next_node.prev = prev_node;
        prev_node.next = next_node;
        
        
    }
    
    public int get(int key) {
        
        int result = -1;
        Node node = node_map.get(key);
        if( node != null){
            result = node.val;
            remove(node);
            add(node);
        }
        
        return result;
    }
    
    public void put(int key, int value) {
        
        Node node = node_map.get(key);
        
        if( node != null){
            remove(node);
            node.val = value;
            add(node);
        } else {
            if(node_map.size()==cache_capacity){
                node_map.remove(tail.prev.key);
                remove(tail.prev);
            }
            
            Node new_node = new Node();
            new_node.key = key;
            new_node.val = value;
            
            node_map.put(key, new_node);
            add(new_node);
        }
        
        
    }
}
