import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Main {

  public static void main(String[] args) {

    Graph graph = new Graph(10);
    graph.print();

    time(graph);

  }

  private static void time(Graph graph) {
    System.out.println("Starting search...");
    long startTime = System.nanoTime();
    boolean found = graph.infPath(1);
    long stopTime = System.nanoTime();

    if(found) {
      System.out.print("Infinite path found in ");
    } else {
      System.out.print("Infinite path not found in ");
    }

    System.out.print(stopTime - startTime + " nanoseconds");
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