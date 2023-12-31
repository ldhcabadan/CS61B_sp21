package gh2;


import deque.Deque;
import deque.LinkedListDeque;

//Note: This file will not compile until you complete the Deque implementations
public class GuitarString {
    /**
     * Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday.
     */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private Deque<Double> buffer;
    private int capacity;
    private double last;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        capacity = (int) Math.round(SR / frequency);
        int cnt = capacity;
        buffer = new LinkedListDeque<Double>();
        while (cnt > 0) {
            buffer.addFirst(0.0);
            cnt--;
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        while (!buffer.isEmpty()) {
            buffer.removeLast();
        }
        int i = 0;
        while (i < capacity) {
            double random = Math.random() - 0.5;
            buffer.addLast(random);
            last = random;
            i++;
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double first = buffer.removeFirst();
        last = DECAY * 0.5 * (first + buffer.get(0));
        buffer.addLast(last);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return this.last;
    }
}

