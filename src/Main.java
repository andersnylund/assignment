import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    Graph graphA = new Graph();
    graphA.addArc(1, 2);
    graphA.addArc(1, 4);
    graphA.addArc(2, 3);
    graphA.addArc(2, 5);
    graphA.addArc(3, 6);
    graphA.addArc(4, 5);
    graphA.addArc(4, 7);
    graphA.addArc(5, 1);
    graphA.addArc(5, 3);
    graphA.addArc(5, 6);
    graphA.addArc(5, 8);
    graphA.addArc(5, 9);
    graphA.addArc(6, 9);
    graphA.addArc(7, 5);
    graphA.addArc(7, 8);
    graphA.addArc(8, 9);

    timeExecution(graphA, 1, 1);
  }

  private static void timeExecution(Graph graph, int startNode, int testRuns) {
    System.out.println("Started timing of execution...");

    List<Long> runTimes = new ArrayList<>();

    for(int i = 0; i < testRuns; i++) {
      long startTime = System.nanoTime();
      graph.infPath(startNode);
      long stopTime = System.nanoTime();
      runTimes.add(stopTime-startTime);
    }

    boolean found = graph.infPath(startNode);
    if(found) {
      System.out.println("FOUND! There was an infinite path");
    } else {
      System.out.println("Not found. There was not an infinite path");
    }

    long average = averageExecutionTime(runTimes);

    System.out.print("Average search time: " + average + "  nanoseconds");
  }

  private static long averageExecutionTime(List<Long> runs) {
    long sum = 0;
    for(long value : runs) {
      sum = sum + value;
    }
    return sum/runs.size();
  }
}