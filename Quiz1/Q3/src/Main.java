import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if(root == null) return result;

        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tempList = new LinkedList<Integer>();
            for(int i = 0; i < size; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                tempList.add(queue.poll().val);
            }
            result.add(tempList);
        }
        return result;
    }

}
