import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Graph {

  private Map<Integer, List<Integer>> arcs = new HashMap<>();
  private Random rand = new Random();

  public Graph() {}

  public Graph(int n) {
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < rand.nextInt(n); j++) {
        addArc(i+1, rand.nextInt(n)+1);
      }
    }

    for(Map.Entry<Integer, List<Integer>> entry : arcs.entrySet()) {
      entry.getValue().sort(Integer::compareTo);
    }

  }

  public void addArc(int startIndex, int endIndex) {
    List<Integer> endNodes = arcs.get(startIndex);
    if(endNodes != null) {
      if(endNodes.contains(endIndex))
        return;
      endNodes.add(endIndex);
    }
    else {
      if (arcs.get(endIndex) != null) {
        if (arcs.get(endIndex).contains(startIndex))
          return;
      }
      endNodes = new ArrayList<>();
      endNodes.add(endIndex);
    }
    arcs.put(startIndex, endNodes);
  }

  public void print() {
    for(Map.Entry<Integer,List<Integer>> entry : arcs.entrySet()) {
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

