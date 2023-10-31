package deque;

import edu.princeton.cs.algs4.StdRandom;
import net.sf.saxon.om.Item;
import org.junit.Test;

public class ArrayDequeTest {
    @Test
    public void RandomizedTest_1() {

        ArrayDeque<Integer> correct = new ArrayDeque<>();
        //BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 50000;
        int j = 0;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 7);
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
                correct.printDeque();
            } else if (operationNumber == 1 && correct.size() > 0 ) {
                Integer num = correct.get(4);
                System.out.println(num);
            } else if (operationNumber == 6 && correct.size() > 0 ) {
                correct.printDeque();
            } else if (operationNumber == 7) {
                for(Integer item : correct) {
                    System.out.println(item);
                }
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

    // Test the get().
    @Test
    public void RandomizedTest_3() {

        ArrayDeque<Integer> correct = new ArrayDeque<>();
        //BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 50000;
        int j = 0;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                System.out.println("addLast " + randVal);
            } else if (operationNumber == 2) {
                // addLast
                int randVal = StdRandom.uniform(0, 10);
                Integer ret = correct.get(randVal);
                System.out.println("get " + ret);
            }
        }
    }

    @Test
    public void featuredTest() {
        ArrayDeque<Integer> MaxArrayDeque = new ArrayDeque<>();
        LinkedListDeque<Integer> LinkedListDeque1 = new LinkedListDeque<>();
        MaxArrayDeque.addFirst(0);
        MaxArrayDeque.addFirst(1);
        MaxArrayDeque.addFirst(2);
        MaxArrayDeque.isEmpty();
        MaxArrayDeque.addFirst(4);
        MaxArrayDeque.addFirst(5);
        MaxArrayDeque.addFirst(6);
        MaxArrayDeque.isEmpty();
        MaxArrayDeque.addFirst(8);
        MaxArrayDeque.addFirst(9);

        LinkedListDeque1.addFirst(0);
        LinkedListDeque1.addFirst(1);
        LinkedListDeque1.addFirst(2);
        LinkedListDeque1.isEmpty();
        LinkedListDeque1.addFirst(4);
        LinkedListDeque1.addFirst(5);
        LinkedListDeque1.addFirst(6);
        LinkedListDeque1.isEmpty();
        LinkedListDeque1.addFirst(8);
        LinkedListDeque1.addFirst(9);

        boolean n = MaxArrayDeque.equals(LinkedListDeque1);

        //int n = MaxArrayDeque.removeFirst();
        int p = 1;
    }


    /**
     * Test remove when resize.

     */
    @Test
    public void featuredTest_2() {
        ArrayDeque<Integer> MaxArrayDeque = new ArrayDeque<>();
        MaxArrayDeque.addFirst(0);
        MaxArrayDeque.addFirst(1);
        MaxArrayDeque.addFirst(2);
        MaxArrayDeque.addFirst(4);
        MaxArrayDeque.addFirst(5);
        MaxArrayDeque.addFirst(6);
        MaxArrayDeque.addFirst(7);
        MaxArrayDeque.addFirst(8);
        MaxArrayDeque.addFirst(9);
        MaxArrayDeque.removeLast();
        MaxArrayDeque.removeLast();
        MaxArrayDeque.removeLast();
        MaxArrayDeque.removeLast();
        MaxArrayDeque.removeLast();
        MaxArrayDeque.removeLast();
        MaxArrayDeque.removeLast();
        MaxArrayDeque.removeLast();
    }

    @Test
    public void featuredTest_3() {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<>();
        ArrayDeque.addLast(0);
        ArrayDeque.removeLast(); //      ==> 0
        ArrayDeque.addFirst(2);
        ArrayDeque.removeFirst(); //     ==> 2
        ArrayDeque.addLast(4);
        ArrayDeque.addLast(5);
        ArrayDeque.get(0); //      ==> 4
        ArrayDeque.addLast(7);
        ArrayDeque.get(2); // 7
        ArrayDeque.addLast(9);
        ArrayDeque.addFirst(10);
        ArrayDeque.addLast(11);
        ArrayDeque.removeLast(); // 11
        ArrayDeque.addLast(13);
        ArrayDeque.addLast(14);
        ArrayDeque.addFirst(15);
        ArrayDeque.addFirst(16);
        ArrayDeque.addFirst(17);
        ArrayDeque.addFirst(18);
        ArrayDeque.addFirst(19);
        ArrayDeque.get(8); //     ==> 5
    }



    @Test
    public void featuredTest_4() {
        ArrayDeque<Integer> MaxArrayDeque = new ArrayDeque<>();
        MaxArrayDeque.addLast(0);
        MaxArrayDeque.removeLast();
        MaxArrayDeque.addFirst(2);
        MaxArrayDeque.removeFirst();
        MaxArrayDeque.addFirst(4);
        MaxArrayDeque.get(0);
        MaxArrayDeque.addFirst(6);
        MaxArrayDeque.addLast(7);
        MaxArrayDeque.addLast(8);
        MaxArrayDeque.addLast(9);
        MaxArrayDeque.get(1);
        MaxArrayDeque.get(2);
        MaxArrayDeque.addLast(12);
        MaxArrayDeque.get(3);
        MaxArrayDeque.get(4);
        MaxArrayDeque.addLast(15);
        MaxArrayDeque.get(0);
        MaxArrayDeque.addLast(17);
        MaxArrayDeque.removeLast();
        MaxArrayDeque.addLast(19);
        MaxArrayDeque.removeFirst(); // 6
    }

}
