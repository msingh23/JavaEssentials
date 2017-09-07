/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.List;

/**
 * @author manu
 *
 */
public class LC113PathSumII {

List<List<Integer>> out = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSum(root, 0, sum, new ArrayList<Integer>());
        return out;
    }
    
    public  void pathSum(TreeNode root, int curr, int sum, List<Integer> list)
    {
        if(root==null) return ;
        curr+=root.val;
        list.add(root.val);
       
        if(root.left == null && null == root.right)
        {
            if(curr==sum)
                out.add(new ArrayList<Integer>(list));
        }
        pathSum(root.left, curr, sum, list);
        pathSum(root.right, curr, sum, list);
        list.remove(list.size()-1);
        curr-=root.val;
    }
}
