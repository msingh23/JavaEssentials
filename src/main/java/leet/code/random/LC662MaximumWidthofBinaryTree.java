/**
 * 
 */
package leet.code.random;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author manu
 *
 */
public class LC662MaximumWidthofBinaryTree {

	public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> index = new LinkedList<Integer>();
        q.add(root);
        index.add(0);
       
        int max = 0;
        //System.out.println(height);
        while(!q.isEmpty())
        {
            
            int l =0;
            int r =0;
            int n = q.size();
            for(int i = 0 ;i < n; i++)
            {
                TreeNode curr = q.poll();
                Integer ind = index.poll();
                if(i==0) l=ind;
                if(i==n-1) r = ind;
                if(curr.left!=null){
                    q.add(curr.left);
                    index.add(2*ind);
                } 
                if(curr.right!=null) {
                    q.add(curr.right);
                    index.add(2*ind +1);
                }
            }
            
            max = Math.max(max, r-l+1);
            
               
        }
        return max;
        
    }
}
