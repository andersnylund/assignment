package main.java;

/**
 * Created by anders on 2/1/17.
 */
public class Graph {

  protected boolean[][] arcs;

  /**
   * Creates a new random graph with n number of nodes
   *
   * @param n Number of nodes
   */
  public Graph(int n) {
    arcs = new boolean[n][n];

    // TODO Create random graph
  }

  public Graph(boolean[][] arcs) {
    this.arcs = arcs;
  }

  public void printGraph() {
    for (int i = 0; i < this.arcs.length; i++) {
      for (int j = 0; j < this.arcs.length; j++) {
        System.out.print(this.arcs[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println("\nOr presented in an other way\n");

    for (int i = 0; i < this.arcs.length; i++) {
      System.out.print("Node " + (i + 1) + " is connected to: ");
      for (int j = 0; j < this.arcs.length; j++) {
        if(arcs[i][j] == true)
          System.out.print((j+1) + " ");
      }
      System.out.println();
    }
  }

  public static boolean infPath(Graph graph, int n) {
    // TODO

    return true;
  }
}
