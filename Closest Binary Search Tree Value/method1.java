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
    int currentNodeV;
    double min;
    public int closestValue(TreeNode root, double target) {
        if(root == null) return (int) target;
        currentNodeV = root.val;
        min = Math.abs(currentNodeV - target);
        dsf(root, target);
        return currentNodeV;
    }
    public void dsf(TreeNode root, double target){
        if(root == null) return;
        double value = root.val;
        if(root.val == target){
            currentNodeV = root.val;
            min = 0;
            return;
        }else if(root.val > target){
            value = root.val-target;
            if(value < min){
                currentNodeV = root.val;
                min = value;
            }
            dsf(root.left, target);
        }else{ // root.val < target
            value = target - root.val;
            if(value < min){
                currentNodeV = root.val;
                min = value;
            }
            dsf(root.right, target);
        }
        return;
    }
}
