public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        while(root != null){
            List list = new ArrayList<>();
            root = traversal(root, list);
            resList.add(list);
        }
        return resList;
    }
    private TreeNode traversal(TreeNode root, List<Integer> list){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            list.add(root.val);
            return null;
        }
        root.left = traversal(root.left, list);
        root.right = traversal(root.right, list);
        return root;
    }
}
