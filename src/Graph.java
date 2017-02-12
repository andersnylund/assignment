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
    return findEndNodesRecursive(startNode, new ArrayList<>());
  }

  private boolean findEndNodesRecursive (int startNode, List<Integer> checkedNodes) {
    if (checkedNodes.contains(startNode)) {
      return true;
    }

    List<Integer> copiedNodes = new ArrayList<>();
    for(Integer node : checkedNodes) {
      copiedNodes.add(node);
    }

    copiedNodes.add(startNode);

    if (arcs.containsKey(startNode)) {
      for(Integer endNode : arcs.get(startNode)) {
        if(findEndNodesRecursive(endNode, copiedNodes)) {
          return true;
        }
      }
    }
    return false;
  }
}

