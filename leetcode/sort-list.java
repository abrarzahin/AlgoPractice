
  class Solution {// merge sort, O(NlogN),where nn is the number of nodes in linked list. The algorithm can be split into 2 phases, Split and Merge.
    // O(logN) where nn is the number of nodes in linked list. 
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    ListNode getMid(ListNode head) {
      ListNode midPrev = null;
      while (head != null && head.next != null) {
          midPrev = (midPrev == null) ? head : midPrev.next;
          head = head.next.next;
      }
      ListNode mid = midPrev.next;
      midPrev.next = null;
      return mid;
  }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    
  }
