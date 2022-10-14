public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            // found p or q or touch the ground
            return root;

        // search p and q from left and right
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            // from root's left & right we found both p and q, so root is the LCA
            return root;
        else
            return left != null ? left : right;
    }
}
