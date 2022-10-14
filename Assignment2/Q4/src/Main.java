public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        queue.addLast(null);
        List<Integer> tempList = new LinkedList<>();
        Boolean bReverse = false;

        while (!queue.isEmpty()) {
            TreeNode temp = queue.removeFirst();
            if (temp != null) {
                tempList.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }

            else {
                if (bReverse) {
                    Collections.reverse(tempList);
                }
                result.add(tempList);
                if (queue.isEmpty()) break;
                tempList = new LinkedList<>();
                bReverse = !bReverse;
                queue.add(null);
            }
        }
        return result;
    }
}
