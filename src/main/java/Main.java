package main.java;

import java.util.ArrayList;
import java.util.List;

public class Main {

  private static boolean infPath(Graph graph, int startNode) {
    startNode--;
    return findNodesRecursive(graph, startNode, new ArrayList<>());
  }

  private static boolean findNodesRecursive(Graph graph, int startNode, List<Integer> checkedNodes) {

    if (checkedNodes.contains(startNode))
      return true;

    List<Integer> copiedNodes = new ArrayList<>();

    for(int node : checkedNodes) {
      copiedNodes.add(node);
    }

    copiedNodes.add(startNode);

    List<Boolean> foundNodes = new ArrayList<>();

    for (int endNode = 0; endNode < graph.arcs.length; endNode++) {
      if(graph.arcs[startNode][endNode])
        foundNodes.add(findNodesRecursive(graph, endNode, copiedNodes));
      if(foundNodes.contains(true))
        return true;
    }

    return false;
  }

  private static void time(Graph graph, int startNode) {

    long startTime = System.nanoTime();
    boolean infinitePath = infPath(graph, startNode);
    long stopTime = System.nanoTime();
    long elapsedTime = stopTime - startTime;

    if(infinitePath) {
      System.out.println("Infinite path found");
    } else {
      System.out.println("Infinite path not found");
    }

    System.out.print("Elapsed time: " + elapsedTime + " nanoseconds");
  }

  public static void main(String[] args) {
    Graph graph = new Graph(25000);
    time(graph, 10);
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
