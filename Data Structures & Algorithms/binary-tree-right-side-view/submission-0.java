/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return List.of();

        var queue = new ArrayDeque<TreeNode>();
        var res = new ArrayList<Integer>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode rightMost = null;
            int length = queue.size();
            for (int i=0; i<length; i++) {
                var node = queue.poll();
                rightMost = node;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (rightMost != null) res.add(rightMost.val);
        }
        return res; 
    }
}
