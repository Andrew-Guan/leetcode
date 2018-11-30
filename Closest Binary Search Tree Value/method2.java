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

    public int closestValue(TreeNode root, double target) {
        if(root == null) return 0;
        TreeNode currentNode = root;
        int value = root.val;
        while(currentNode != null){
            if(Math.abs(value - target) > Math.abs(currentNode.val - target)){
                value = currentNode.val;
            }
            currentNode = (currentNode.val - target > 0) ? currentNode.left: currentNode.right;
        }
        return value;
    }
}
