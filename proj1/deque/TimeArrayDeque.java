package deque;

import deque.ArrayDeque;

public class TimeArrayDeque {
    public static void main(String[] args) {
        //timeArrayDequeAddFirst();
        timeArrayDequeAddFirstRemoveLast();
    }

    public static void timeArrayDequeAddFirst() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        Timing.addFirst(arrayDeque);
    }

    public static void timeArrayDequeAddFirstRemoveLast() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        Timing.addFirstRemoveLast(arrayDeque);
    }
}
