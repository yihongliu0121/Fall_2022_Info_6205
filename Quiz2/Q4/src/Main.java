import com.sun.tools.jconsole.JConsoleContext;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkList list = new LinkList();
        Node newnode = new Node(5);
        Node newnode2 = new Node(1);
        list.sortedInsert(newnode);
        list.sortedInsert(newnode2);

        System.out.println("You can debugger to test, 5 can be added to the end");



    }
}
