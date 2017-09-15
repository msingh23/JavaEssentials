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
public class LC297SerializeandDeserializeBinaryTree {

	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer out = new StringBuffer();
        if(root == null) return out.toString();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int empty = 0;
        
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            if(curr!=null)
            {
                 out.append(curr.val);
                 out.append(",");
                 if(curr.left == null && curr.right ==null && empty == q.size()) break;
                 
                if(curr.left == null) empty++;
                if(curr.right == null) empty++;
                q.add(curr.left);
                q.add(curr.right);
                
            }
            else
            {
                out.append("*");
                out.append(",");
             empty--;   
            }
        }
        String s = out.toString().substring(0, out.length()-1);
        //System.out.println(s);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null ||  data.equals("")) return null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        String [] tree = data.split(",");
        //for(String s : tree) System.out.println(s);
        int i =0;
        TreeNode root = new TreeNode(Integer.parseInt(tree[i++]));
        q.add(root);
        while( !q.isEmpty() && i < tree.length )
        {
            TreeNode curr = q.poll();
            
            if( i < tree.length)
            {
                String leftS = tree[i++];
                if(!leftS.equals("*"))
                {
                    TreeNode left = new TreeNode(Integer.parseInt(leftS));
                    curr.left = left;
                    q.add(left);
                }
            }
            
            if( i < tree.length)
            {
                String rightS = tree[i++];
                if(!rightS.equals("*"))
                {
                 TreeNode right = new TreeNode(Integer.parseInt(rightS));
                 curr.right = right;
                 q.add(right);   
                }
            }
            
        }
        return root;
    }
}

