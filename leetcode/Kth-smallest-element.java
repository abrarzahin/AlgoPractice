import java.util.LinkedList;

import javax.swing.tree.TreeNode;
class Solution {
    public int kthSmallest(TreeNode root, int k) {
      LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
  
      while (true) {
        while (root != null) {
          stack.add(root);
          root = root.left;
        }
        root = stack.removeLast();
        // return when k-- is the first element
        if (--k == 0) return root.val;
        root = root.right;
      }
    }
  }