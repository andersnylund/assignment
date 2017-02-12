import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    Graph graph = new Graph(10000);

    timeExecution(graph, 1,100000);
  }

  private static void timeExecution(Graph graph, int startNode, int testRuns) {
    System.out.println("Starting timing of execution...");

    List<Long> runs = new ArrayList<>();

    for(int i = 0; i < testRuns; i++) {
      long startTime = System.nanoTime();
      graph.infPath(1);
      long stopTime = System.nanoTime();
      runs.add(stopTime-startTime);
    }

    boolean found = graph.infPath(startNode);
    if(found) {
      System.out.println("FOUND! There was an infinite path");
    } else {
      System.out.println("Not found. There was not an infinite path");
    }

    long average = averageExecutionTime(runs);

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





























//    Graph graph4 = new Graph();
//    graph4.addArc(1, 2);
//    graph4.addArc(2, 3);
//    graph4.addArc(2, 4);
//    graph4.addArc(3, 5);
//    graph4.addArc(4, 5);
//    graph4.addArc(5, 2);
//
//    graph4.print();
//
//    System.out.println(graph4.infPath(1));


//    Graph graph1 = new Graph();
//    graph1.addArc(1, 2);
//    graph1.addArc(1, 4);
//    graph1.addArc(2, 3);
//    graph1.addArc(2, 5);
//    graph1.addArc(3, 6);
//    graph1.addArc(4, 5);
//    graph1.addArc(4, 7);
//    graph1.addArc(5, 1);
//    graph1.addArc(5, 3);
//    graph1.addArc(5, 6);
//    graph1.addArc(5, 8);
//    graph1.addArc(5, 9);
//    graph1.addArc(6, 9);
//    graph1.addArc(7, 5);
//    graph1.addArc(7, 8);
//
//
//    graph1.addArc(8, 9);
//
//    graph1.print();
//
//    System.out.print(graph1.infPath(6));