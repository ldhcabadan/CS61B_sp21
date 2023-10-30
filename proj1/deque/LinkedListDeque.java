package deque;


import java.util.Iterator;
import java.util.Objects;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T>{
    public class Node {
        private T item;
        private Node prev;
        private Node next;

        public Node(T i, Node n1, Node n2) {
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
    public LinkedListDeque(T x) {
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(x, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /**
     * Adds an item of type T to the front of the deque.
     * Assume that item is never null.
     */
    public void addFirst(T x) {
        Node temp = new Node(x, sentinel, sentinel.next);
        sentinel.next.prev = temp;
        sentinel.next = temp;
        size++;
    }

    /**
     * Adds an item of type T to the back of the deque.
     * Assume that item is never null.
     */
    public void addLast(T x) {
        Node temp = new Node(x, sentinel.prev, sentinel);
        sentinel.prev.next = temp;
        sentinel.prev = temp;
        size++;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
    //@Override
    /*public boolean isEmpty() {
        return size == 0;
    }*/

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
    public T removeFirst() {
        if (sentinel.next != sentinel) {
            Node retNode = sentinel.next;
            T ret = retNode.item;
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
    public T removeLast() {
        if (sentinel.prev != sentinel) {
            Node retNode = sentinel.prev;
            T ret = retNode.item;
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
    public T get(int index) {
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



    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }


    private class LinkedListDequeIterator implements Iterator<T> {
        private int wizPos;
        private Node node;

        public LinkedListDequeIterator() {
            wizPos = 0;
            node = sentinel;
        }

        public boolean hasNext() {
            return wizPos < size();
        }

        public T next() {
            node = node.next;
            wizPos++;
            return node.item;
        }
    }



    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        int maxSize = Math.min(this.size(), ((Deque<?>) o).size());
        for(int i = 0; i < maxSize; i++) {
            if (!this.get(i).equals(((Deque<?>) o).get(i))) {
                return false;
            }
        }
        return true;
    }


    public T getRecursive(int index) {
        if (index >= this.size()) {
            return null;
        }
        Node node = sentinel.next;
        return getRecursiveHelper(index, node);
    }

    private T getRecursiveHelper(int index, Node node) {
        if (index == 0) {
            return node.item;
        } else {
            return getRecursiveHelper(index - 1, node.next);
        }
    }
}
