package leet.code.random;

public class LC543DiameterofBinaryTree {

	 /*
    int max = 0;
    Map<TreeNode,Integer> height = new HashMap<TreeNode,Integer>();
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
    
        max = Math.max(maxHeight(root.left) + maxHeight(root.right), max);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return max;
        
    }
     public int maxHeight(TreeNode root)
     {
         if(root == null ) return 0;
         if(!height.containsKey(root)) {
             height.put(root, 1 + Math.max(maxHeight(root.left), maxHeight(root.right)));
         }
         return height.get(root);
     }
     */
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) 
    {
        height(root);
        return max;
    }
    
    public int height(TreeNode root)
    {
        if(root == null) return 0;
        
        int left = height(root.left);
        int right = height(root.right);
        
        max = Math.max(left+right, max);
        return 1 + Math.max(left, right);
            
    }
	
}
