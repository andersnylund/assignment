import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Graph {

  private Dictionary<Integer, ArrayList<Integer>> nodes = new Hashtable<>();

  public void addArc(int startIndex, int endIndex) {
    ArrayList<Integer> endNodes = nodes.get(startIndex);
    if(endNodes != null) {
      if(endNodes.contains(endIndex))
        return;
      endNodes.add(endIndex);
    }
    else {
      if (nodes.get(endIndex) != null) {
        if (nodes.get(endIndex).contains(startIndex))
          return;
      }
      endNodes = new ArrayList<>();
      endNodes.add(endIndex);
    }
    nodes.put(startIndex, endNodes);
  }
}

