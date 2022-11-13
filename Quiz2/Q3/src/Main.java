public class Main {
    public static void main(String[] args) {
        System.out.println("Test Case for Q3");
        Node root = getBST();
        Print(root, 5, 16);
    }

    // Given range between 5 and 8 it will print 6, 7, 8
    private static Node<Integer> getBST(){
        Node<Integer> root = new Node<>(8);
        root.left = new Node<>(3);
        root.right = new Node<>(10);

        root.left.left = new Node<>(1);
        root.left.right = new Node<>(6);

        root.right.right = new Node<>(14);

        root.left.right.left = new Node<>(4);
        root.left.right.right = new Node<>(17);

        root.right.right.left = new Node<>(13);

        return root;
    }

    private static void Print(Node<Integer> node, int n1, int n2) {
        if (node == null) {
            return;
        }

        if (n1 < node.data) {
            Print(node.left, n1, n2);
        }

        if (n1 <= node.data && n2 >= node.data) {
            System.out.print(node.data + " ");
        }

        Print(node.right, n1, n2);
    }

}