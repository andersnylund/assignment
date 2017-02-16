import java.util.*;

public class Graph {

  private Map<Integer, Set<Integer>> arcs = new HashMap<>();
  private Random rand = new Random();

  public Graph() {}

  public Graph(int n) {
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < rand.nextInt(n); j++) {
        addArc(i+1, rand.nextInt(n)+1);
      }
    }
  }

  public void addArc(int startIndex, int endIndex) {

    // No arcs to itself
    if(startIndex == endIndex) {
      return;
    }

    // Must be a directed graph
    if(arcs.get(endIndex) != null) {
      if(arcs.get(endIndex).contains(startIndex)) {
        return;
      }
    }

    Set<Integer> endNodes = arcs.get(startIndex);
    if (endNodes == null) {
      endNodes = new TreeSet<>();
    }

    endNodes.add(endIndex);
    arcs.put(startIndex, endNodes);
  }

  public void print() {
    for(Map.Entry<Integer,Set<Integer>> entry : arcs.entrySet()) {
      System.out.print(entry.getKey() + " -> ");
      for(Integer value : entry.getValue()) {
        System.out.print(value + " ");
      }
      System.out.println();
    }
  }

  public boolean infPath(int startNode) {
    return findEndNodesRecursive(startNode, new ArrayList<>(), new ArrayList<>());
  }

  private boolean findEndNodesRecursive (int startNode, List<Integer> checkedNodes, List<Integer> deadEnds) {
    if (checkedNodes.contains(startNode)) {
      return true;
    }

    // Create a copy of the currently checked nodes
    // Java passes arguments by reference
    List<Integer> clonedNodes = new ArrayList<>();
    for(Integer node : checkedNodes) {
      clonedNodes.add(node);
    }

    clonedNodes.add(startNode);

    // TODO resolve if checking for deadEnds is efficient or not

    // If startNode has arcs
    if (arcs.containsKey(startNode)) {
      // Iterate all arcs
      for(Integer endNode : arcs.get(startNode)) {

        if(deadEnds.contains(endNode)) {
          return false;
        }
        if (findEndNodesRecursive(endNode, clonedNodes, deadEnds)) {
          return true;
        } else {
          deadEnds.add(endNode);
        }
      }

    }
    return false;
  }
}

