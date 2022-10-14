public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        queue.addLast(null);
        TreeNode prev = null;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            if (cur != null) {
                prev = cur;
                if (cur.left != null) queue.addLast(cur.left);
                if (cur.right != null) queue.addLast(cur.right);
            }

            else {
                result.add(prev.val);
                if (queue.isEmpty()) break;
                queue.addLast(null);
            }
        }
        return result;
    }
}
