package deque;

import afu.org.checkerframework.checker.igj.qual.I;

public class ArrayDeque<Item> {
    private Item[] items;
    private int length;
    // length is the maximum length of the array.(Initially, 8)
    // instead, the size function is the actual size of the array. (Initially, 0)
    private int nextFirst;
    private int nextLast;

    /**
     * Creates an empty list.
     */
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        length = 8;
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
        System.arraycopy(items, 0, a, length / 2, length);
        items = a;
        nextFirst = length / 2 - 1;
        nextLast = length * 3 / 2;
        length = capacity;
    }

    private void resizeSmall(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, nextFirst + 1, a, (length / 2 - (nextLast - nextFirst - 1)) / 2, size());
        items = a;
        int newNextFirst = 0;
        int newNextLast = 0;
        newNextFirst = (length / 2 - (nextLast - nextFirst - 1)) / 2 - 1;
        newNextLast = (length / 2 - (nextLast - nextFirst - 1)) / 2 + (nextLast - nextFirst) - 1;
        nextFirst = newNextFirst;
        nextLast = newNextLast;
        length = capacity;
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
            nextFirst = length - 1;
        }
        if (resizeFlag) {
            resizeBig(2 * length);
        }
    }

    public void addLast(Item x) {
        boolean resizeFlag = false;
        if (nextFirst == nextLast) {
            resizeFlag = true;
        }
        items[nextLast] = x;
        if (nextLast != length - 1) {
            nextLast++;
        } else {
            nextLast = 0;
        }
        if (resizeFlag) {
            resizeBig(2 * length);
        }
    }

    public Item removeFirst() {
        if(size() <= 0) {
            return null;
        }
        Item temp = null;
        if (nextFirst == length - 1) {
            nextFirst = 0;
        } else {
            nextFirst++;
        }
        temp = items[nextFirst];
        items[nextFirst] = null;
        if(length >= 16) {
            if(length > 4 * (nextLast - nextFirst) && nextLast > nextFirst) {
                resizeSmall(length / 2);
            }
        }
        return temp;
    }

    public Item removeLast() {
        if(size() <= 0) {
            return null;
        }
        Item temp = null;
        if (nextLast == 0) {
            nextLast = length - 1;
        } else {
            nextLast--;
        }
        temp = items[nextLast];
        items[nextLast] = null;
        if(length >= 16) {
            if(length > 4 * (nextLast - nextFirst) && nextLast > nextFirst) {
                resizeSmall(length / 2);
            }
        }
        return temp;
    }

    public Item get(int index) {
        int res = 0;
        res = index + nextFirst;
        if (res > length) {
            return items[res - length + 1];
        }
        return items[res + 1];
    }

    public int size() {
        if (nextFirst >= nextLast) {
            return length - (nextFirst - nextLast) - 1;
        }
        return nextLast - nextFirst - 1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void printDeque() {
        int temp = nextFirst + 1;
        /*if (nextFirst == length - 1) {
            temp = 0;
        } else {
            temp = nextFirst + 1;
        }*/
        while(temp != nextLast - 1) {
            if (temp == length) {
                temp = 0;
            }
            System.out.print(items[temp]);
            temp++;
        }
        System.out.println(items[temp]);
    }
}
