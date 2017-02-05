public class Main {

  public static void main(String[] args) {

    int graphSize;

    if(args.length != 0) {
      try {
        graphSize = Integer.parseInt(args[0]);
        System.out.println("Creating random graph...");
        Graph graph = new Graph(graphSize);
        timeExecution(graph, 1);
      }
      catch (Exception e) {
        System.out.println("Invalid argument");
        e.printStackTrace();
        System.exit(0);
      }
    }

    else {
      boolean[][] arcs3 = new boolean[][]{
        {false, true, false, false, false},
        {false, false, true, true, false},
        {false, false, false, false, true},
        {false, false, false, false, true},
        {false, true, false, false, false},
      };

      Graph graph3 = new Graph(arcs3);

      timeExecution(graph3,4);
    }
  }

  private static void timeExecution(Graph graph, int startNode) {

    long startTime = System.nanoTime();
    boolean infinitePath = graph.infPath(startNode);
    long stopTime = System.nanoTime();
    long elapsedTime = stopTime - startTime;

    if(infinitePath) {
      System.out.println("Infinite path found");
    } else {
      System.out.println("Infinite path not found");
    }

    System.out.println("Elapsed time: " + elapsedTime + " nanoseconds");
  }
}


//    boolean[][] arcs1 = new boolean[][]{
//      {false, true, false, true, false, false, false, false, false},
//      {false, false, true, false, true, false, false, false, false},
//      {false, false, false, false, false, true, false, false, false},
//      {false, false, false, false, true, false, true, false, false},
//      {true, false, false, false, false, true, false, true, true},
//      {false, false, false, false, false, false, false, false, true},
//      {false, false, false, false, true, false, false, true, false},
//      {false, false, false, false, false, false, false, false, true},
//      {false, false, false, false, false, false, false, false, false},
//    };
//
//
//    boolean[][] arcs3 = new boolean[][]{
//      {false, true, false, false, false},
//      {false, false, true, true, false},
//      {false, false, false, false, true},
//      {false, false, false, false, true},
//      {false, true, false, false, false},
//    };
//
//    Graph graph1 = new Graph(arcs1);
//    Graph graph3 = new Graph(arcs3);
//
//    System.out.println(infPath(graph1, 5));
//    System.out.println(infPath(graph3, 1));