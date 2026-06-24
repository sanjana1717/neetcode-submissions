class Solution {

    // Main function
    // Checks whether subRoot exists inside root tree
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // If main tree becomes null,
        // subtree cannot be found
        if (root == null) {
            return false;
        }

        // Check if current tree starting from root
        // is exactly same as subRoot
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Otherwise search in left subtree
        // OR search in right subtree
        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    // Helper function
    // Checks whether two trees are identical
    private boolean isSameTree(TreeNode p, TreeNode q) {

        // If both nodes are null,
        // trees match till here
        if (p == null && q == null) {
            return true;
        }

        // If one is null and other is not,
        // trees are different
        if (p == null || q == null) {
            return false;
        }

        // If node values are different,
        // trees are different
        if (p.val != q.val) {
            return false;
        }

        // Left subtrees must match
        // AND right subtrees must match
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}