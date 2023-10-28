package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

public class ArrayDequeTest {
    @Test
    public void RandomizedTest_1() {

        ArrayDeque<Integer> correct = new ArrayDeque<>();
        //BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 50000;
        int j = 0;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                // addLast
                //int randVal = StdRandom.uniform(0, 100);
                int randVal = 0;
                    randVal = j;
                    j++;
                correct.addLast(randVal);
                System.out.println("addLast" + randVal);
            } else if (operationNumber == 5 && correct.size() > 0) {
                // getLast
                int last = correct.removeLast();
                System.out.println("removeLast" + last);
            } else if (operationNumber == 2) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addFirst(randVal);
                System.out.println("addFirst" + randVal);
            } else if (operationNumber == 3 && correct.size() > 0) {
                // getLast
                int first = correct.removeFirst();
                System.out.println("removeFirst" + first);
            } else if (operationNumber == 4 && correct.size() > 0 ) {
                // size
                int size = correct.size();
            } else if (operationNumber == 1 && correct.size() > 0 ) {
                Integer num = correct.get(4);
                System.out.println(num);
            } else if (operationNumber == 6 && correct.size() > 0 ) {
                correct.printDeque();
            }
        }
    }

    @Test
    public void myTest_1() {
        ArrayDeque<Integer> correct = new ArrayDeque<>();
        for(int j = 0; j < 10; j++) {
            for(int i = 0; i < 4; i++) {
                correct.addFirst(i);
                correct.addLast(i+4);
            }
            for(int i = 0; i < 4; i++) {
                correct.removeLast();
                correct.removeFirst();
            }
            for(int i = 0; i < 4; i++) {
                correct.addFirst(i);
            }
            for(int i = 0; i < 4; i++) {
                correct.removeLast();
            }
            for(int i = 0; i < 17; i++) {
                correct.addLast(i+4);
            }
            for(int i = 0; i < 15; i++) {
                correct.removeLast();
            }
            int blablabla = 0;
        }
    }
}
