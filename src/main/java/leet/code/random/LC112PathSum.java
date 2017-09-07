/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC112PathSum {

	
	public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSumHelper(root, 0 , sum);
        
    }
    
    public boolean hasPathSumHelper(TreeNode root, int currSum, int sum)
    {
        if(root == null) return false;
       
        currSum+=root.val;
        
        //if(currSum>sum) return false;
       
        if (root.left == null && root.right ==null)
        {
            if(currSum ==sum) return true;
            return false;
        }
        
        return hasPathSumHelper(root.left, currSum, sum) || hasPathSumHelper(root.right, currSum, sum); 
        
    }
}
