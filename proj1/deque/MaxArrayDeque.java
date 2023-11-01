package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> myComparator;

    /**
     * Creates a MaxArrayDeque without a given Comparator.
     */
    /*public MaxArrayDeque() {
        super();
        this.myComparator = new itemComparator<T>();
    }*/

    /**
     * Creates a MaxArrayDeque with the given Comparator.
     */
    public MaxArrayDeque(Comparator<T> c) {
        super();
        this.myComparator = c;
    }

    /**
     * Returns the maximum element in the deque as governed by the previously given Comparator.
     * If the MaxArrayDeque is empty, simply return null.
     */
    public T max() {
        return max(myComparator);
    }

    /**
     * returns the maximum element in the deque as governed by the parameter Comparator c.
     * If the MaxArrayDeque is empty, simply return null.
     */
    public T max(Comparator<T> c) {
        if (this.isEmpty()) {
            return null;
        }
        if (c == null) {
            return null;
        }
        T res = this.get(0);
        for (T item : this) {
            if (c.compare(item, res) > 0) {
                res = item;
            }
        }
        return res;
    }
}



