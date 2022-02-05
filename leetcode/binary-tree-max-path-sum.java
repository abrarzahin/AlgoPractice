
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  class Solution {
    
    int max_sum = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode node){
		
		maxGain(node);
		
		return max_sum;
	}
	
	
	// O(N), O(H)
	
	public int maxGain(TreeNode node){
			
		if(node == null) return 0;
		
		// max sum on the left and right subtrees of the node
		int leftGain = Math.max(maxGain(node.left), 0);
		int rightGain= Math.max(maxGain(node.right), 0);
		
		// the price of starting a new path where node is a highest node
		int priceNewPath = node.val + leftGain + rightGain;
		
		// update max_sum if new path has greater value
		max_sum = Math.max(max_sum, priceNewPath);
		
		return node.val + Math.max(leftGain, rightGain);
	}
}