package deque;


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

    private void normalization() {
        Item[] temp = (Item[]) new Object[length];
        if(nextFirst > nextLast) {
            System.arraycopy(items, nextFirst + 1, temp, 1, length - nextFirst - 1);
            System.arraycopy(items, 0, temp, length - nextFirst, nextLast);
            nextLast = nextLast + length - nextFirst;
            nextFirst = 0;
            items = temp;
        }
    }

    private void resizeBig(int capacity) {
        normalization();
        Item[] a = (Item[]) new Object[capacity];
        /*if(nextFirst > nextLast) {
            Item[] b = (Item[]) new Object[capacity / 2];
            System.arraycopy(items, nextFirst + 1, b, 1, length - nextFirst - 1);
            for(int i = 0; i <);
        }*/
        System.arraycopy(items, 0, a, length / 2, length);
        items = a;
        nextFirst = length / 2;
        nextLast = length * 3 / 2 - 1;
        length = capacity;
    }

    private void resizeSmall(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        if(nextFirst > nextLast) {
            normalization();
        }
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
        /*boolean resizeFlag = false;
        if (nextFirst == nextLast) {
            resizeFlag = true;
        }*/
        if (Math.abs(nextFirst - nextLast) <= 1 && nextFirst > nextLast) {
            resizeBig(2 * length);
        }
        items[nextFirst] = x;
        if (nextFirst != 0) {
            nextFirst--;
        } else {
            nextFirst = length - 1;
        }
        /*if (resizeFlag) {
            resizeBig(2 * length);
        }*/




    }

    public void addLast(Item x) {
        /*boolean resizeFlag = false;
        if (nextFirst == nextLast) {
            resizeFlag = true;
        }*/
        if (Math.abs(nextFirst - nextLast) <= 1 && nextFirst > nextLast) {
            resizeBig(2 * length);
        }
        items[nextLast] = x;
        if (nextLast != length - 1) {
            nextLast++;
        } else {
            nextLast = 0;
        }
        /*if (resizeFlag) {
            resizeBig(2 * length);
        }*/
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
        if (length >= 16) {
            if (length > 4 * size()) {
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
        if (nextFirst >= nextLast) {
            return length - (nextFirst - nextLast) - 1;
        }
        return nextLast - nextFirst - 1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void printDeque() {
        /*int temp = nextFirst;

        int switchFlag = 0;
        while(nextFirst > nextLast && temp != length) {
            System.out.print(items[temp] );
            temp++;
        }
        if(temp == length) {
            temp = 0;
            switchFlag = 1;
        }
        while(temp <= nextLast - 2) {
            if(switchFlag == 0) {
                temp++;
                switchFlag = 1;
            }
            System.out.print(items[temp]);
            System.out.print(" ");
            temp++;
        }
        System.out.println(items[temp]);*/

    }
}
