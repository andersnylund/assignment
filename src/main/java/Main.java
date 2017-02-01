package main.java;

/**
 * Created by anders on 1/28/17.
 */
public class Main {
  public static void main(String[] args) {

    boolean[][] arcs3 = new boolean[][]{
      {false, true, false, false, false},
      {false, false, true, true, false},
      {false, false, false, false, true},
      {false, false, false, false, true},
      {false, true, false, false, false},
    };

    Graph graph3 = new Graph(arcs3);

    graph3.printGraph();
  }
}