public class Solution {

    // Function to find the Lowest Common Ancestor (LCA)
    // in a Binary Search Tree (BST)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Start searching from the root node
        TreeNode cur = root;

        // Continue until we find the answer
        while (cur != null) {

            // If BOTH p and q are greater than current node,
            // then both nodes must be in the RIGHT subtree.
            // So move to the right child.
            if (p.val > cur.val && q.val > cur.val) {
                cur = cur.right;

            // If BOTH p and q are smaller than current node,
            // then both nodes must be in the LEFT subtree.
            // So move to the left child.
            } else if (p.val < cur.val && q.val < cur.val) {
                cur = cur.left;

            // Otherwise,
            // one node is on the left and the other is on the right,
            // OR one of them is the current node itself.
            // Therefore, current node is the Lowest Common Ancestor.
            } else {
                return cur;
            }
        }

        // This will never happen for a valid BST where
        // both p and q exist, but Java requires a return statement.
        return null;
    }
}