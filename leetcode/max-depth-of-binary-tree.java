
public class TreeNode{
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(){}
   TreeNode(int val){this.val=val;}
   TreeNode(int val, TreeNode left, TreeNode right){
       this.val = val;
       this.left= left;
       this.right= right;
   }
}// time: O(N) num of nodes, Space: O(N) worse case unbalanced
// but if balanced O(logN)
class Solution {
    public int maxDepth(TreeNode root) {
        
        if(root==null){
            return 0;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth= maxDepth(root.right);
        
        return Math.max(leftDepth, rightDepth) +1;
        
    }
}