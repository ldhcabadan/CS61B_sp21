package deque;

import afu.org.checkerframework.checker.igj.qual.I;

public class ArrayDeque<Item> {
    private Item[] items;
    private int size;

    /**
     * Creates an empty list.
     */
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 8;
    }

    /**
     * Resize the list.
     * Remember: The starting size of your array should be 8.
     * For arrays of length 16 or more,
     * your usage factor should always be at least 25%.
     * For smaller arrays, your usage factor can be arbitrarily low.
     */

    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
        size = capacity;
    }

    public void addFirst(Item x) {
        if (size == items.length) {
            resize(4 * size);
        }
        Item[] temp = (Item[]) new Object[size];
        System.arraycopy(items, 0, temp, 1, size - 1);
        temp[0] = x;
        System.arraycopy(temp, 0, items, 0, size);
        size++;
    }

    public void addLast(Item x) {
        if (size == items.length) {
            resize(4 * size);
        }
        items[size] = x;
        size++;
    }

    public void removeFirst() {
        Item[] temp = (Item[]) new Object[size];
        System.arraycopy(items, 1, temp, 0, size - 1);
        System.arraycopy(temp, 0, items, 0, size);
        if (size >= 4 * items.length) {
            resize(items.length);
        }
    }

    public void removeLast() {
        items[size] = null;
        if (size >= 4 * items.length) {
            resize(items.length);
        }
    }

    public Item get(int index) {
        return items[index];
    }
}
