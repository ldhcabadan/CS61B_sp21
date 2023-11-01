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
        if (this.isEmpty()) {
            return null;
        }
        T res = this.get(0);
        Comparator<T> defaultItemComparator = new ItemComparator();
        for (T item : this) {
            if (defaultItemComparator.compare(item, res) > 0) {
                res = item;
            }
        }
        return res;
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



    public static class ItemComparator<T> implements Comparator<T> {
        public int compare(T o1, T o2) {
            //if (o1 instanceof Comparable && o2 instanceof Comparable) {
                Comparable<T> comparable1 = (Comparable<T>) o1;
                Comparable<T> comparable2 = (Comparable<T>) o2;
                return comparable1.compareTo((T) comparable2);
            //} else {
                // 处理不可比较的情况
            //    throw new IllegalArgumentException("o1 and o2 must be comparable");
            //}
        }
    }
}



