public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Please use debugger to test, you will find all the node has a parent after running populateParent");
        Node root = getBST();
        //preorder traversal
        populateParent(root);
    }


    public static void populateParent(Node node)
    {
        if (node == null) return;

        if (node.left != null) node.left.parent = node;
        if (node.right != null) node.right.parent = node;

        //System.out.print(node.data +  "'s parent:" );
        //System.out.print(parent);
        //System.out.println();

        populateParent(node.left);
        populateParent(node.right);

    }

    private static Node<Integer> getBST(){
        Node<Integer> root = new Node<>(8);
        root.parent = root;

        root.left = new Node<>(3);
        root.right = new Node<>(10);
        //root.left.parent = root;
        //root.right.parent = root;


        root.left.left = new Node<>(1);
        root.left.right = new Node<>(6);
        //root.left.left.parent = root.left;
        //root.left.right.parent = root.left;

        root.right.right = new Node<>(14);
        //root.right.right.parent = root.right;

        root.left.right.left = new Node<>(4);
        root.left.right.right = new Node<>(17);
        //root.left.right.left.parent = root.left.right;
        //root.left.right.right.parent = root.left.right;


        root.right.right.left = new Node<>(13);
        //root.right.right.left.parent = root.right.right;

        return root;
    }
}