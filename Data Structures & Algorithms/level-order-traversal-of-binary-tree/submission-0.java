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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();

        var queue = new ArrayDeque<TreeNode>();
        queue.add(root);

        var res = new ArrayList<List<Integer>>();

        while (!queue.isEmpty()) {
            var levelLength = queue.size();
            var level = new ArrayList<Integer>();
            for (int i = 0; i < levelLength; i++) {
                var cur = queue.poll();
                level.add(cur.val);

                if (cur.left != null) {
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(level);
        }

        return res;
    }
}
