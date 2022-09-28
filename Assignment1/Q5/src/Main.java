public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node result = new Node(insertVal);
            result.next = result;
            return result;
        }

        Node node = head;
        while (node.next != head) {
            if (node.val <= insertVal && insertVal <= node.next.val) {
                break;
            }
            else if (node.val <= insertVal && node.next.val < insertVal &&  node.val > node.next.val) {
                break;
            }
            else if (node.val > insertVal && node.next.val >= insertVal &&  node.val > node.next.val) {
                break;
            }
            else {
                node = node.next;
            }
        }

        Node inserted = new Node(insertVal);
        inserted.next = node.next;
        node.next = inserted;
        return head;
    }
}
