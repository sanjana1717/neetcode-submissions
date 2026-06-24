class Solution {

    public boolean isBalanced(TreeNode root) {

        // dfs(root) returns int[]{balanced, height}
        // [0] means balanced value
        // if balanced is 1, return true
        return dfs(root)[0] == 1;
    }

    private int[] dfs(TreeNode root) {

        // Empty tree is balanced
        // Height of empty tree is 0
        if (root == null) {
            return new int[]{1, 0};
        }

        // Get left subtree result
        // left[0] = is left subtree balanced?
        // left[1] = height of left subtree
        int[] left = dfs(root.left);

        // Get right subtree result
        // right[0] = is right subtree balanced?
        // right[1] = height of right subtree
        int[] right = dfs(root.right);

        // Current node is balanced only if:
        // 1. left subtree is balanced
        // 2. right subtree is balanced
        // 3. height difference <= 1
        boolean balanced = (left[0] == 1 && right[0] == 1) &&
                            (Math.abs(left[1] - right[1]) <= 1);

        // Height of current node
        int height = 1 + Math.max(left[1], right[1]);

        // Return current node's balanced status and height
        return new int[]{balanced ? 1 : 0, height};
    }
}