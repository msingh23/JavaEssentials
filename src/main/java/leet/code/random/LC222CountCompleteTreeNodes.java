/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC222CountCompleteTreeNodes {

	/*
    public int countNodes(TreeNode root) {
        
        if(root == null) return 0;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    */
    public int countNodes(TreeNode root) 
    {
        if(root == null) return 0;
        int lh = getHeightLeft(root.left);
        int rh = getHeightRight(root.right);

        if(lh == rh) 
        {
            return (1<<lh+1) -1  ;
        }
        return countNodes(root.right) + countNodes(root.left) + 1;
    }
    
    public int getHeightLeft(TreeNode root)
    {
        int h = 0;
        while(root != null)
        {
            root = root.left;
            h++;
        }
        return h;
    }
    
    public int getHeightRight(TreeNode root)
    {
         int h = 0;
        while(root != null)
        {
            root = root.right;
            h++;
        }
        return h;
    }
}
