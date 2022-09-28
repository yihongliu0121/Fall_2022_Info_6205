public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int length = getLength(head);

        ListNode dummyNode = new ListNode(-1, head);
        ListNode prev1 = dummyNode;
        ListNode prev2 = dummyNode;

        if (k > length / 2) {
            k = length - k + 1;
        }

        for (int i = 0; i < k - 1; i++) {
            prev1 = prev1.next;
        }
        ListNode node1 = prev1.next;

        for (int i = 0; i < length - k; i++) {
            prev2 = prev2.next;
        }
        ListNode node2 = prev2.next;



        System.out.println(prev1.val);
        System.out.println(node1.val);
        System.out.println(prev2.val);
        System.out.println(node2.val);

        ListNode temp = node2.next;

        if (node1.next == node2) {
            prev1.next = node2;
            node2.next = node1;
            node1.next = temp;
        }

        else {

            prev1.next = node2;
            node2.next = node1.next;
            prev2.next = node1;
            node1.next = temp;
        }
        return dummyNode.next;
    }

    private int getLength(ListNode head) {
        int length = 1;
        while (head.next != null) {
            head = head.next;
            length++;
        }

        return length;
    }

}
