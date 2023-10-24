
package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

public class RandomizedTest {
    @Test
    public void RandomizedTest_1() {

        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = correct.size();
                int size1 = broken.size();
                //System.out.println("size: " + size);
                //System.out.println("size1: " + size1);
            } else if (operationNumber == 2 && correct.size() > 0 && broken.size() > 0) {
                // getLast
                int last = correct.getLast();
                int last1 = broken.getLast();
                //System.out.println("Last: " + last);
                //System.out.println("Last1: " + last1);
            } else if (operationNumber == 3 && correct.size() > 0 && broken.size() > 0) {
                // removeLast
                correct.removeLast();
                broken.removeLast();
                //System.out.println("removeLast");
            }
        }
    }

}
