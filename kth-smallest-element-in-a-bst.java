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
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode cur = root;
        
        while(cur !=null || !stack.isEmpty()){
            while(cur != null){
                stack.add(cur);
                cur=cur.left;
            }
            
            cur=stack.pop();
            if(--k ==0) break;
            cur=cur.right;
        }
        
        return cur.val;
    }
}
