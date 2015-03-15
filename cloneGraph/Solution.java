package cloneGraph;

import java.util.*;

public class Solution {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        // Use HashMap to remember the visited nodes
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>(); 
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for (int i = 0; i < cur.neighbors.size(); i++) {
                if (!map.containsKey(cur.neighbors.get(i))) {
                    UndirectedGraphNode newNode = new UndirectedGraphNode(cur.neighbors.get(i).label);
                    map.put(cur.neighbors.get(i), newNode);
                    queue.add(cur.neighbors.get(i));
                }
                // No matter if this node is in map, we need to add it to cur.neighbors.get(i)
                // to complete the relationship of graph
                map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));
            }
        }
        return copy;
    }

}
