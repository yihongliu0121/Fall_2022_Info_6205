import java.util.ListIterator;

public class LinkList  {
    public Node head;
    public int length = 0;

    public LinkList() {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
    }

    public void sortedInsert(Node new_node)
    {
        Node current;
        if (head == null || head.data >= new_node.data) {
            new_node.next = head;
            head = new_node;
        }
        else {
            current = head;
            while (current.next != null && current.next.data < new_node.data)
                current = current.next;

            //we find the position of the node
            new_node.next = current.next;
            current.next = new_node;
        }
    }

}