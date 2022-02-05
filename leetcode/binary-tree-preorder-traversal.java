public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (){}
    TreeNode (int val) {this.val = val;}
    TreeNode ( int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/*
Time complexity : we visit each node exactly once, thus the time complexity is \mathcal{O}(N)O(N), where NN is the number of nodes, i.e. the size of tree.

Space complexity : depending on the tree structure, we could keep up to the entire tree, therefore, the space complexity is \mathcal{O}(N)O(N).
*/

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if( root == null){
            return result;
        }
        
        stack.push(root);
        
        while(!stack.empty()){
            TreeNode node= stack.pop();
            result.add(node.val);
            
            if(node.right != null){
                stack.push(node.right);
            }
            
            if( node.left != null){
                stack.push(node.left);
            }
        }
        
        return result;
        
    }
}
