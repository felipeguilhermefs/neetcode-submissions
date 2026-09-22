/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        var root = new Node(node.val);
        var lookup = new HashMap<Integer, Node>();
        lookup.put(node.val, root);
        var toVisit = new ArrayDeque<Node>();
        toVisit.offer(node);

        while (!toVisit.isEmpty()) {
            var current = toVisit.poll();
            for (var next: current.neighbors) {
                var newNeighbor = lookup.get(next.val);
                if (newNeighbor == null) {
                    toVisit.offer(next);
                    newNeighbor = new Node(next.val);
                    lookup.put(next.val, newNeighbor);
                } 
                lookup.get(current.val).neighbors.add(newNeighbor);
            }
        } 
        return root;
    }
}