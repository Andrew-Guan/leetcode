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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        boolean leftChild = false;
        TreeNode traversor = root;
        TreeNode parentNode = null;
        while(traversor != null){
            if(traversor.val == p.val){
                if(traversor.right!= null) {
                    return findLeftMost(traversor.right);
                } else if(leftChild){
                    return parentNode;
                } else {
                    return null;
                }
            } else if(traversor.val < p.val){
                // don't need to consider the exception here, because p is in the tree for sure according to the question. 
                traversor = traversor.right;
            } else { // traversor. val > p.val
                leftChild = true;
                parentNode = traversor;
                traversor = traversor.left;
            }
        }
        return null;
    }
    public TreeNode findLeftMost(TreeNode t1){
        if(t1.left != null){
            return findLeftMost(t1.left);
        } else{
            return t1;
        }
    }
}
