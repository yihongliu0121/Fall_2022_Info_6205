public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    //Q1
    public class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if(head == null) return null;
            return toBST(head, null);
        }
        //find the mid point of the linkedlist
        public TreeNode toBST(ListNode head, ListNode tail){
            ListNode slow = head;
            ListNode fast = head;
            if(head == tail) return null;
            while(fast != tail && fast.next != tail){
                fast = fast.next.next;
                slow = slow.next;
            }
            TreeNode mid = new TreeNode(slow.val);
            mid.left = toBST(head, slow); //left side half
            mid.right = toBST(slow.next,tail); //right side half
            return mid;
        }
    }

    //Q2
    public class Solution {
        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            Node leftHead = treeToDoublyList(root.left);
            Node rightHead = treeToDoublyList(root.right);
            Node leftTail, rightTail;

            if (leftHead != null) {
                leftTail = leftHead.left;
                root.left = leftTail;
                leftTail.right = root;
            } else {
                leftTail = leftHead = root;
            }
            if (rightHead != null) {
                rightTail = rightHead.left;
                root.right = rightHead;
                rightHead.left = root;
            } else {
                rightTail = rightHead = root;
            }

            leftHead.left = rightTail;
            rightTail.right = leftHead;

            return leftHead;
        }
    }

    //Q3
    public class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }

        boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
            if (root == null) return true;
            if (min != null && root.val <= min.val) return false;
            if (max != null && root.val >= max.val) return false;
            return isValidBST(root.left, min, root)
                    && isValidBST(root.right, root, max);
        }
    }

    //Q4
    public class Solution {
        TreeNode first = null, second = null;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);


        public void recoverTree(TreeNode root) {
            inorderTraverse(root);

            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

        void inorderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraverse(root.left);
            if (root.val < prev.val) {
                if (first == null) {
                    first = prev;
                }
                second = root;
            }
            prev = root;
            inorderTraverse(root.right);
        }
    }

    //Q5
    class BSTIterator {
        private Stack<TreeNode> stk = new Stack<>();

        private void pushLeftBranch(TreeNode p) {
            while (p != null) {
                stk.push(p);
                p = p.left;
            }
        }

        public BSTIterator(TreeNode root) {
            pushLeftBranch(root);
        }

        public int next() {
            TreeNode p = stk.pop();
            pushLeftBranch(p.right);
            return p.val;
        }

        public boolean hasNext() {
            return !stk.isEmpty();
        }
    }

    //Q6
    public class Codec {
        private final static String SEP = ",";
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                return;
            }
            sb.append(root.val).append(SEP);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            LinkedList<Integer> inorder = new LinkedList<>();
            for (String s : data.split(SEP)) {
                inorder.offer(Integer.parseInt(s));
            }
            return deserialize(inorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode deserialize(LinkedList<Integer> nodes, int min, int max) {
            if (nodes.isEmpty()) return null;
            int rootVal = nodes.getFirst();
            if (rootVal > max || rootVal < min) {
                return null;
            }
            nodes.removeFirst();
            TreeNode root = new TreeNode(rootVal);
            root.left = deserialize(nodes, min, rootVal);
            root.right = deserialize(nodes, rootVal, max);

            return root;
        }
    }

    //Q7
    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (root == null) {
                return null;
            }

            TreeNode successor = null;
            if (root.val > p.val) {
                successor = inorderSuccessor(root.left, p);
                if (successor == null) {
                    successor = root;
                }
            }
            if (root.val < p.val) {
                successor = inorderSuccessor(root.right, p);
            }

            if (root.val == p.val) {
                successor = getMinNode(root.right);
            }

            return successor;
        }

        private TreeNode getMinNode(TreeNode p) {
            while (p != null && p.left != null) {
                p = p.left;
            }
            return p;
        }
    }

    //Q8
    class Solution {
        int sum = 0;
        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) return 0;
            traverse(root, low, high);
            return sum;
        }

        void traverse(TreeNode root, int low, int high) {
            if (root == null) {
                return;
            }
            if (root.val < low) {
                traverse(root.right, low, high);
            } else if (root.val > high) {
                traverse(root.left, low, high);
            } else {
                sum += root.val;
                traverse(root.right, low, high);
                traverse(root.left, low, high);
            }
        }
    }

}
