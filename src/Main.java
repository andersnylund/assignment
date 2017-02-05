public class Main {

  public static void main(String[] args) {
    int graphSize;
    try {
      graphSize = Integer.parseInt(args[0]);
      Graph graph = new Graph(graphSize);
      long startTime = System.currentTimeMillis();
      boolean infinitePath = graph.infPath(1);
      long stopTime = System.currentTimeMillis();
      long elapsedTime = stopTime - startTime;

      if(infinitePath) {
        System.out.println("Infinite path found");
      } else {
        System.out.println("Infinite path not found");
      }

      System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
    } catch (Exception e) {
      System.out.println("Invalid argument");
      e.printStackTrace();
      System.exit(0);
    }
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
