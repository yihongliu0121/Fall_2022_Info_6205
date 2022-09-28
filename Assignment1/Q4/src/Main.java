public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        int N = 0;
        ListNode node = head;
        while (node != null) {
            N += 1;
            node = node.next;
        }

        int numberOfNodes = N / k;
        int numberOfExtra = N % k;

        ListNode[] ans = new ListNode[k];

        node = head;

        for (int i = 0; i < k; i++) {
            ans[i] = head;
            ListNode prev = null;
            for (int j = 0; j < numberOfNodes + (numberOfExtra > 0 ? 1 : 0); j++) {
                prev = node;
                node = node.next;
            }
            numberOfExtra -= 1;
            if (prev != null) {
                prev.next = null;
            }
            head = node;
        }
        return ans;
    }
}
