/**
 * 
 */
package leet.code.random;

import java.util.HashMap;
import java.util.Map;

/**
 * @author manu
 *
 */
public class LC106ConstructBinaryTreefromInorderandPostorderTraversal {

public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int idx =0;
        for(int i : inorder) map.put(i,idx++);
        int end = inorder.length;
        return buildTree(inorder, 0, end-1, postorder, 0, end-1, map);
    }
    
     public TreeNode buildTree(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend, Map<Integer, Integer> map) 
     {
         if(istart>iend || pstart>pend) return null;
         if(istart == iend) return new TreeNode(inorder[istart]);
             
        TreeNode root = new TreeNode(postorder[pend]);
        int split = map.get(postorder[pend]);
       // ps+ri-is-1
        root.left = buildTree( inorder, istart , split -1, postorder, pstart, pstart+ split -istart-1,map);
        root.right = buildTree( inorder, split+1 , iend, postorder, pstart+ split -istart, pend-1, map);
         
         return root;
     }
}

