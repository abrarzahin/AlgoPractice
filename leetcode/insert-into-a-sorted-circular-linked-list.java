/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node() {}
    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
/*
Time Complexity:O(N) where N is the size of list. In the worst case, we would iterate through the entire list.
Space Complexity:O(1). It is a constant space solution.
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node();
            node.val = insertVal;
            node.next = node;
            return node;
        }
        Node max = head;
        // find the max value position in the circle
        while (max.next != head && max.val <= max.next.val) {
            max = max.next;
        }
        // min value will be the next of the max value since circle ends at the max
        Node min = max.next, cur = min;
        
        if (insertVal >= max.val || insertVal <= min.val) {
            Node node = new Node(insertVal, min);
            max.next = node;
        } else {
            while (cur.next.val < insertVal) {
                cur = cur.next;
            } 
            Node node = new Node(insertVal, cur.next);
            cur.next = node;
        }
        return head;
    }
}
