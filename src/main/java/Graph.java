package main.java;

import java.util.Random;

class Graph {

  boolean[][] arcs;

  Graph(int n) {
    arcs = new boolean[n][n];

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        arcs[i][j] = false;
      }
    }

    Random random = new Random();

    // Iterate trough every node
    for(int startNode = 0; startNode < n; startNode++) {

      // random amount of end nodes
      int numberOfArcs = random.nextInt(n);

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
        }
        counter++;
      }
    }
  }

  Graph(boolean[][] arcs) {
    this.arcs = arcs;
  }

  void print() {
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

