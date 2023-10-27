package deque;

import afu.org.checkerframework.checker.igj.qual.I;

public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /**
     * Creates an empty list.
     */
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 8;
        nextFirst = 3;
        nextLast = 4;
    }

    /**
     * Resize the list.
     * Remember: The starting size of your array should be 8.
     * For arrays of length 16 or more,
     * your usage factor should always be at least 25%.
     * For smaller arrays, your usage factor can be arbitrarily low.
     */

    private void resizeBig(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, size / 2, size);
        items = a;
        nextFirst = size / 2 - 1;
        nextLast = size * 3 / 2;
        size = capacity;
    }

    private void resizeSmall(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, nextFirst + 1, a, (size - (nextLast - nextFirst - 1)) / 2, nextLast - nextFirst - 1);
        items = a;
        int newNextFirst = 0;
        int newNextLast = 0;
        newNextFirst = (size - (nextLast - nextFirst - 1)) / 2 - 1;
        newNextLast = (size - (nextLast - nextFirst - 1)) / 2 + (nextLast - nextFirst);
        nextFirst = newNextFirst;
        nextLast = newNextLast;
        size = capacity;
    }



    public void addFirst(Item x) {
        boolean resizeFlag = false;
        if (nextFirst == nextLast) {
            resizeFlag = true;
        }
        items[nextFirst] = x;
        if (nextFirst != 0) {
            nextFirst--;
        } else {
            nextFirst = size;
        }
        if (resizeFlag) {
            resizeBig(2 * size);
        }
    }

    public void addLast(Item x) {
        boolean resizeFlag = false;
        if (nextFirst == nextLast) {
            resizeFlag = true;
        }
        items[nextLast] = x;
        if (nextLast != size - 1) {
            nextLast++;
        } else {
            nextLast = 0;
        }
        if (resizeFlag) {
            resizeBig(2 * size);
        }
    }

    public void removeFirst() {
        if (nextFirst == size) {
            nextFirst = 0;
        } else {
            nextFirst++;
        }
        items[nextFirst] = null;
        if(size >= 16) {
            if(size > 4 * (nextLast - nextFirst) && nextLast > nextFirst) {
                resizeSmall(size / 2);
            }
        }
    }

    public void removeLast() {
        if (nextLast == 0) {
            nextFirst = size;
        } else {
            nextFirst--;
        }
        items[nextLast] = null;
        if(size >= 16) {
            if(size > 4 * (nextLast - nextFirst) && nextLast > nextFirst) {
                resizeSmall(size / 2);
            }
        }
    }

    public Item get(int index) {
        int res = 0;
        res = index + nextFirst;
        if (res > size) {
            return items[res - size + 1];
        }
        return items[res + 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
