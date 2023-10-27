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
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                //broken.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1 && correct.size() > 0) {
                // getLast
                int last = correct.removeLast();
                //int last1 = broken.getLast();
                //System.out.println("Last: " + last);
                //System.out.println("Last1: " + last1);
            } else if (operationNumber == 2) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addFirst(randVal);
                //int size1 = broken.size();
                //System.out.println("size: " + size);
                //System.out.println("size1: " + size1);
            } else if (operationNumber == 3 && correct.size() > 0) {
                // getLast
                int first = correct.removeFirst();
                //int last1 = broken.getLast();
                //System.out.println("Last: " + last);
                //System.out.println("Last1: " + last1);
            } else if (operationNumber == 4 && correct.size() > 0 ) {
                // size
                int size = correct.size();
                // removeLast
                //correct.removeLast();
                //broken.removeLast();
                //System.out.println("removeLast");
            }
        }
    }
}
