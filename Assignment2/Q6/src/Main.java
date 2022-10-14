public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int width = 1;
        root.val = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            //calculate the width for the queue before adding new nodes into the queue
            width = Math.max(queue.peekLast().val - queue.peekFirst().val + 1, width);
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    cur.left.val = cur.val * 2 - 1; //change the val of the node directly
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    cur.right.val = cur.val * 2;
                    queue.offer(cur.right);
                }
            }
        }
        return width;
    }
}
