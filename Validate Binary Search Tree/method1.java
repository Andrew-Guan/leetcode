/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer>  values = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        dsf(root);
        for(int i = 0; i< values.size()-1; i++){
            if(values.get(i) >= values.get(i+1))
                return false;
        }
        return true;
        
    }
    public void dsf(TreeNode root){
        if(root.left!=null){
            dsf(root.left); 
        }
        values.add(root.val);
        if(root.right!=null){
            dsf(root.right); 
        }
        return;
    }
}
