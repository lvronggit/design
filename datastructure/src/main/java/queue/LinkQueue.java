package queue;


/**
 * 链表的队列
 */
public class LinkQueue {
    private Node head;

    private Node tail;

    public static void main(String[] args) {


        LinkQueue linkQueue = new LinkQueue();

        linkQueue.pop();
        linkQueue.push("one");
        linkQueue.push("two");
        linkQueue.push("three");

        linkQueue.push("four");
        linkQueue.push("five");
        linkQueue.push("six");

        linkQueue.pop();
        linkQueue.pop();
        linkQueue.pop();
        linkQueue.pop();
        linkQueue.pop();
        linkQueue.pop();


        linkQueue.push("one1");
        linkQueue.pop();
        linkQueue.push("two2");
        linkQueue.pop();
        linkQueue.push("three3");
    }


    public String pop() {
        Node f = head;
        if (f == null) {
            return null;
        }

        Node next = f.next;
        String value = f.value;
        head = next;
        if (f.next == null) {
            tail = null;
        }
        f.next = null; //gc
        f.value = null; //gc
        next.prev = null; //gc

        System.out.println(value);
        return f.value;
    }

    public void push(String value) {
        final Node f = tail;
        Node newNode = new Node(value, null, f);
        tail = newNode;
        if (f == null) {
            head = newNode;
        } else {
            f.next = newNode;
        }
    }


    class Node {
        String value;

        Node next;

        Node prev;

        public Node(String value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

}
