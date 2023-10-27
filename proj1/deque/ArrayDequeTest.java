package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

public class ArrayDequeTest {
    @Test
    public void RandomizedTest_1() {

        ArrayDeque<Integer> correct = new ArrayDeque<>();
        //BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 50000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 7);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
            } else if (operationNumber == 1 && correct.size() > 0) {
                // getLast
                int last = correct.removeLast();
            } else if (operationNumber == 2) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addFirst(randVal);
            } else if (operationNumber == 3 && correct.size() > 0) {
                // getLast
                int first = correct.removeFirst();
            } else if (operationNumber == 4 && correct.size() > 0 ) {
                // size
                int size = correct.size();
            } else if (operationNumber == 5 && correct.size() > 0 ) {
                Integer num = correct.get(0);
            } else if (operationNumber == 6 && correct.size() > 0 ) {
                correct.printDeque();
            }
        }
    }
}
