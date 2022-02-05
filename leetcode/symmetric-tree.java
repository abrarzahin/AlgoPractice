public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val) {this.val = val}
    TreeNode (int val, TreeNode left, TreeNode right){
        this.val = val;
        tis.left = left;
        this.right = right;
    } 
}

class Solution {
    /*Time complexity : O(n). Because we traverse the entire input tree once, the total run time is O(n), where n is the total number of nodes in the tree.
Space complexity : The number of recursive calls is bound by the height of the tree. In the worst case, the tree is linear and the height is in O(n). Therefore, space complexity due to recursive calls on the stack is O(n) in the worst case.
    */
    public boolean isSymmetric(TreeNode root) {
        
        if( root == null){
            return true;
        }  
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror( TreeNode node1, TreeNode node2){
        if( node1 == null && node2 == null){
            return true;
        }
        if( node1 == null || node2 == null){
            return false;
        }
        if( node1.val != node2.val){
            return false;
        }
        return node1.val == node2.val 
            && isMirror( node1.left, node2.right)
            && isMirror( node1.right, node2.left);
        
    }
}