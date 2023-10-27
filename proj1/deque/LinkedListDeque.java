package deque;


public class LinkedListDeque<Item> {
    public class Node {
        private Item item;
        private Node prev;
        private Node next;

        public Node(Item i, Node n1, Node n2) {
            item = i;
            prev = n1;
            next = n2;
        }
    }

    private Node sentinel;
    private int size;

    /**
     * Creates an empty Deque.
     */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /**
     * Creates a Deque with an initial node.
     */
    public LinkedListDeque(Item x) {
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(x, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /**
     * Adds an item of type T to the front of the deque.
     * Assume that item is never null.
     */
    public void addFirst(Item x) {
        Node temp = new Node(x, sentinel, sentinel.next);
        sentinel.next.prev = temp;
        sentinel.next = temp;
        size++;
    }

    /**
     * Adds an item of type T to the back of the deque.
     * Assume that item is never null.
     */
    public void addLast(Item x) {
        Node temp = new Node(x, sentinel.prev, sentinel);
        sentinel.prev.next = temp;
        sentinel.prev = temp;
        size++;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items in the deque.
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        int i = size;
        Node temp = sentinel.next;
        while (i > 0) {
            System.out.print(temp.item + " ");
            temp = temp.next;
            i--;
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public Item removeFirst() {
        if (sentinel.next != sentinel) {
            Node retNode = sentinel.next;
            Item ret = retNode.item;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size--;
            return ret;
        } else {
            return null;
        }
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public Item removeLast() {
        if (sentinel.prev != sentinel) {
            Node retNode = sentinel.prev;
            Item ret = retNode.item;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size--;
            return ret;
        } else {
            return null;
        }
    }

    /**
     * Gets the item at the given index,
     * where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.
     */
    public Item get(int index) {
        if (index > size) {
            return null;
        } else {
            int i = index;
            Node temp = sentinel.next;
            while (i > 0) {
                temp = temp.next;
                i--;
            }
            System.out.println(temp.item);
            return temp.item;
        }
    }
}
