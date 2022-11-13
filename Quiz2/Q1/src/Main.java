import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        System.out.println("Please use debbuger to test, you will find 3.next changed to 2, 7.next changed to 6");
        BinaryTree<Integer> tree = getTree();
        connect(tree.root);

    }

    public static Node connect(Node<Integer> root) {
        if (root == null) return null;
        // 遍历「三叉树」，连接相邻节点
        traverse(root.left, root.right);
        return root;
    }

    // 三叉树遍历框架
    public static void traverse(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node2.next = node1;

        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);

        traverse(node1.right, node2.left);
    }

    private static BinaryTree<Integer> getTree(){
        BinaryTree<Integer> tree = new BinaryTree<>();
        // a tree 1 2 3 4 5 6
        tree.root = new Node<>(1);

        tree.root.left = new Node<>(2);
        tree.root.right = new Node<>(3);

        tree.root.left.left = new Node<>(4);
        tree.root.left.right = new Node<>(5);
        tree.root.right.left = new Node<>(6);
        tree.root.right.right = new Node<>(7);


        tree.root.left.left.left = new Node<>(8);
        tree.root.left.right.left = new Node<>(9);
        tree.root.right.left.right = new Node<>(10);
        tree.root.right.right.right = new Node<>(11);

        return tree;
    }

}
