/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC449SerializeandDeserializeBST {

	/*
	 // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
       
          StringBuffer out = new StringBuffer();
         if(null == root) return out.toString();
         preorder(root, out);
          return out.substring(0, out.length()-1);
       
    }
    
    public void preorder(TreeNode root, StringBuffer buff)
    {
        if(root==null) return;
        
        buff.append(root.val);
        buff.append(",");
        preorder(root.left, buff);
        preorder(root.right, buff);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null ||  data.equals("")) return null;
        //System.out.println(data);
        String [] tree = data.split(",");
        int n = tree.length;
        int i =0;
        TreeNode root = new TreeNode(Integer.parseInt(tree[i++]));
        i = createBST(root, root, null, i, n, tree);
        createBST(root, null, root, i, n, tree);
        return root;
    }
    /*
    tree 3 1 2 4
    root = 3
    i =2
    n= 4
    max = 1
    min = null
    */
	
	/*
    public int createBST(TreeNode root, TreeNode max, TreeNode min, int  i, int n, String [] tree)
    {
        if(i<n)
        {
            if( (max==null || max.val > Integer.parseInt(tree[i] )) && (min==null || min.val < Integer.parseInt(tree[i]) ) )
            {
                TreeNode left =null, right =null;
                
                if (Integer.parseInt(tree[i] ) < root.val)
                {
                    left = new TreeNode(Integer.parseInt(tree[i++]) );
                    root.left = left;
                    i = createBST(root.left, root.left, min, i, n, tree);
                    i = createBST(root.left, max, root.left, i, n, tree);
                }
                else
                {
                    right = new TreeNode(Integer.parseInt(tree[i++]) );
                    root.right = right;
                    i = createBST(root.right, root.right, min, i, n, tree);
                    i = createBST(root.right, max, root.right, i, n, tree);
                }
                
            }
                
        }
        
        return i;
    }
    */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
       
          StringBuffer out = new StringBuffer();
         if(null == root) return out.toString();
         preorder(root, out);
          return out.substring(0, out.length()-1);
       
    }
    
    public void preorder(TreeNode root, StringBuffer buff)
    {
        if(root==null) return;
        
        buff.append(root.val);
        buff.append(",");
        preorder(root.left, buff);
        preorder(root.right, buff);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null ||  data.equals("")) return null;
        //System.out.println(data);
        String [] tree = data.split(",");
        int n = tree.length;
        int i =0;
        TreeNode root = new TreeNode(0);
        createBST(root, null, null, i, n, tree);
        //createBST(root, null, root, i, n, tree);
        return root;
    }
    /*
    tree 3 1 2 4
    root = 3
    i =2
    n= 4
    max = 1
    min = null
    */
    public int createBST(TreeNode root, TreeNode max, TreeNode min, int  i, int n, String [] tree)
    {
        if(i<n)
        {
            int val  = Integer.parseInt(tree[i++]) ;
            if( (max==null || max.val > val) && (min==null || min.val < val) ) 
            {
                root.val  = val; 
                root.left = new TreeNode(0);
                root.right = new TreeNode(0);
                int stat = createBST(root.left, root, min, i, n, tree);
                if(stat == i) 
                    root.left = null;
                i =stat;
                    stat = createBST(root.right, max, root, i, n, tree);
                if(stat == i) 
                    root.right = null;
                i = stat;
            }
            else
            {
                i--;
                root = null;
            }
                
        }
        return i;
    }
	
}
