public class Solution {
  
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
        
    // step 1. cut the list to two halves
    ListNode temp = null, slow = head, fast = head;
    
    while (fast != null && fast.next != null) {
      temp = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    
    temp.next = null;
    
    // step 2. sort each half
    ListNode left_side = sortList(head);
    ListNode right_side = sortList(slow);
    
    // step 3. merge l1 and l2
    return merge(left_side, right_side);
  }
  
  ListNode merge(ListNode l1, ListNode l2) {
    ListNode sorted_temp = new ListNode(0);
    ListNode current_node = sorted_temp;
    
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        current_node.next = l1;
        l1 = l1.next;
      } else {
        current_node.next = l2;
        l2 = l2.next;
      }
      current_node = current_node.next;
    }
    
    if (l1 != null)
      current_node.next = l1;
    
    if (l2 != null)
      current_node.next = l2;
    
    return sorted_temp.next;
  }

}
