import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    Graph graph = new Graph(10000);

    timeExecution(graph,1 ,10000000);
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