/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// time:O(N), space:O(1), recursive
class Solution {
   public TreeNode buildTree(int[] preorder, int[] inorder) {
    return helper(0, 0, inorder.length - 1, preorder, inorder);
}

public TreeNode helper(int preStart, int inStart, int inEnd, int[] 
preorder, int[] inorder) {
    if (preStart > preorder.length - 1 || inStart > inEnd) {
        return null;
    }
    // root starts from the first preorder index
    TreeNode root = new TreeNode(preorder[preStart]);
    int inIndex = 0; // Index of current root in inorder
    // find inorder root index by using the root value from preorder
    for (int i = inStart; i <= inEnd; i++) {
        if (inorder[i] == root.val) {
            inIndex = i;
        }
    }
    // for pre left its the right value of root
    // for in left search from the start to the left value of the root index
    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, 
inorder);

    //for in right search from the right side of the in root index
    // for the pre right its prestart + inindex-instart+1
    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, 
inEnd, preorder, inorder);
    return root;
}
}
