public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
        
    }
    
    private void buildString(TreeNode root, StringBuilder sb){
        if( root == null){
            sb.append("#,");
            return;
        }
        
        sb.append(root.val);
        sb.append(",");
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> strList = new 
LinkedList(Arrays.asList(data.split(",")));
        return buildTree(strList);
    }
    
    private TreeNode buildTree(LinkedList<String> strList){
        String first = strList.removeFirst();
        if( first.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(first));
        
        root.left = buildTree(strList);
        root.right = buildTree(strList);
        
        return root;
    }
    
    
    
}
