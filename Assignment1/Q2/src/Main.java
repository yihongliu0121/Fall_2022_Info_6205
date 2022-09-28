public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;

        ListNode dummyNode = new ListNode(-1, head);
        ListNode cur = dummyNode;

        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode temp = cur.next.next;
                cur.next.next = null;
                cur.next = temp;

            }
            else {
                cur = cur.next;
            }
        }


        return dummyNode.next;


    }
}
