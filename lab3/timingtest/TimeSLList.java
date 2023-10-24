package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        SLList<Integer> trashList = new SLList<Integer>();
        int n = 0;
        int[] numList;
        //numList = new int[]{1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
        numList = new int[]{1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
        AList<Integer> Ns = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        AList<Integer> opCount = new AList<Integer>();
        for(int i = 0; i < 8; i++) {
            n = numList[i];
            for(int j = 0; j < n; j++) {
                trashList.addFirst(1);
            }
            Stopwatch sw = new Stopwatch();
            for(int j = 0; j < 10000; j++) {
                trashList.getLast();
            }
            double timeInSeconds = sw.elapsedTime();
            Ns.addLast(numList[i]);
            times.addLast(timeInSeconds);
            opCount.addLast(10000);
        }
        printTimingTable(Ns, times, opCount);
    }

}
