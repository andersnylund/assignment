import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Graph {

  private boolean[][] arcs;

  Graph(boolean[][] arcs) {
    this.arcs = arcs;
  }

  Graph(int n) {
    arcs = new boolean[n][n];

    Random random = new Random();
    // Iterate trough every node
    for(int startNode = 0; startNode < n; startNode++) {
      // random amount of end nodes
      int numberOfArcs = random.nextInt(1);
      int counter = 0;
      while (counter < numberOfArcs) {
        // Select random end node
        int endNode = random.nextInt(n);
        // prevent arcs from a node to itself
        if(startNode != endNode) {
          // check if inverse connection already exist
          if(!arcs[endNode][startNode]) {
            arcs[startNode][endNode] = true;
          }
          else {
            arcs[startNode][endNode] = false;
          }
        }
        counter++;
      }
    }
  }

  public void setArcs(boolean[][] arcs) {
    this.arcs = arcs;
  }

  public boolean[][] getArcs () {
    return arcs;
  }

  public boolean infPath(int startNode) {
    startNode--;
    return findNodesRecursive(this, startNode, new ArrayList<>());
  }

  private boolean findNodesRecursive(Graph graph, int startNode, List<Integer> checkedNodes) {

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

  public void printArcs() {
    for (int i = 0; i < this.arcs.length; i++) {
      System.out.print("Node " + (i + 1) + " is connected to: ");
      for (int j = 0; j < this.arcs.length; j++) {
        if(arcs[i][j])
          System.out.print((j+1) + " ");
      }
      System.out.println();
    }
  }
}

