public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        // 层序遍历的结点队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 结点对应的位置队列
        Queue<Integer> posQueue = new LinkedList<>();
        posQueue.offer(0);
        // key : position | value: node.val list
        Map<Integer, List<Integer>> map = new TreeMap<>();

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int pos = posQueue.poll();
            List<Integer> list = map.getOrDefault(pos, new LinkedList<>());
            list.add(node.val);
            map.put(pos, list);

            if(node.left != null){
                queue.offer(node.left);
                posQueue.offer(pos - 1);
            }
            if(node.right != null){
                queue.offer(node.right);
                posQueue.offer(pos + 1);
            }
        }
        return new ArrayList<>(map.values());
    }
}
