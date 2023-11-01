package deque;


import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T> {
    private T[] items;
    private int length;
    // length is the maximum length of the array.(Initially, 8)
    // instead, the size function is the actual size of the array. (Initially, 0)
    private int nextFirst;
    private int nextLast;
    /**
     * Creates an empty list.
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
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

    private void normalization() {
        T[] temp = (T[]) new Object[length];
        if (nextFirst >= nextLast) {
            System.arraycopy(items, nextFirst + 1, temp, 1, length - nextFirst - 1);
            System.arraycopy(items, 0, temp, length - nextFirst, nextLast);
            if (nextFirst == nextLast) {
                nextLast = 0;
            } else {
                nextLast = nextLast + length - nextFirst;
            }
            nextFirst = 0;
            items = temp;
        }
    }

    private void resizeBig(int capacity) {
        normalization();
        T[] a = (T[]) new Object[capacity];
        /*if(nextFirst > nextLast) {
            Item[] b = (Item[]) new Object[capacity / 2];
            System.arraycopy(items, nextFirst + 1, b, 1, length - nextFirst - 1);
            for(int i = 0; i <);
        }*/
        System.arraycopy(items, 0, a, length / 2, length);
        items = a;
        nextFirst = length / 2;
        nextLast = length * 3 / 2;
        length = capacity;
    }

    private void resizeSmall(int capacity) {
        T[] a = (T[]) new Object[capacity];
        normalization();
        System.arraycopy(items, nextFirst + 1, a,
                (length / 2 - (nextLast - nextFirst - 1)) / 2, size());

        items = a;
        int newNextFirst = 0;
        int newNextLast = 0;
        newNextFirst = (length / 2 - (nextLast - nextFirst - 1)) / 2 - 1;
        newNextLast = (length / 2 - (nextLast - nextFirst - 1)) / 2 + (nextLast - nextFirst) - 1;
        nextFirst = newNextFirst;
        nextLast = newNextLast;
        length = capacity;
    }


    public void addFirst(T x) {
        //normalization();
        boolean resizeFlag = false;
        if (nextFirst == nextLast) {
            resizeFlag = true;
        }
        if (resizeFlag) {
            resizeBig(2 * length);
        }
        items[nextFirst] = x;
        if (nextFirst != 0) {
            nextFirst--;
        } else {
            nextFirst = length - 1;
        }
    }

    public void addLast(T x) {
        //normalization();
        boolean resizeFlag = false;
        if (nextFirst == nextLast) {
            resizeFlag = true;
        }
        if (resizeFlag) {
            resizeBig(2 * length);
        }
        items[nextLast] = x;
        if (nextLast != length - 1) {
            nextLast++;
        } else {
            nextLast = 0;
        }
    }

    public T removeFirst() {
        if (size() <= 0) {
            return null;
        }
        T temp = null;
        //normalization();
        if (nextFirst == length - 1) {
            nextFirst = 0;
        } else {
            nextFirst++;
        }
        temp = items[nextFirst];
        items[nextFirst] = null;
        final int leastLength = 16;
        if (length >= leastLength) {
            if (length > (3 * size())) {
                resizeSmall(length / 2);
            }
        }
        return temp;
    }

    public T removeLast() {
        if (size() <= 0) {
            return null;
        }
        T temp = null;
        //normalization();
        if (nextLast == 0) {
            nextLast = length - 1;
        } else {
            nextLast--;
        }
        temp = items[nextLast];
        items[nextLast] = null;
        final int leastLength = 16;
        if (length >= leastLength) {
            if (length > (3 * size())) {
                resizeSmall(length / 2);
            }
        }
        return temp;
    }

    public T get(int index) {
        if (index >= size()) {
            return null;
        }
        int res = 0;
        normalization();
        if (nextFirst < nextLast) {
            res = nextFirst + index + 1;
        } else {
            res = nextFirst + index + 1;
            if (res >= length) {
                res = res - length + 1;
            }
        }
        return items[res];
    }

    public int size() {
        //normalization();
        if (nextFirst >= nextLast) {
            return length - (nextFirst - nextLast) - 1;
        }
        return nextLast - nextFirst - 1;
    }

    /*public boolean isEmpty() {
        return size() == 0;
    }*/

    public void printDeque() {
        normalization();
        int first;
        int last;
        first = nextFirst + 1;
        last = nextLast - 1;
        if (first >= length) {
            first = first - length;
        }
        while (first < last) {
            System.out.print(items[first] + " ");
            first++;
        }
        System.out.println(items[first]);
    }


    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }


    private class ArrayDequeIterator implements Iterator<T> {
        private int wizPos;

        ArrayDequeIterator() {
            normalization();
            wizPos = nextFirst + 1;
        }

        public boolean hasNext() {
            return wizPos < nextLast;
        }

        public T next() {
            T item = items[wizPos];
            wizPos++;
            return item;
        }
    }


    public boolean equals(Object o) {
        if (o == null || !(o instanceof Deque) || size() != ((Deque<?>) o).size()) {
            return false;
        }
        int maxSize = Math.min(this.size(), ((Deque<?>) o).size());
        for (int i = 0; i < maxSize; i++) {
            if (!this.get(i).equals(((Deque<?>) o).get(i))) {
                return false;
            }
        }
        return true;
    }




}
