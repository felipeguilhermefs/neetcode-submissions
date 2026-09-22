class WordDictionary {

    private class Node {
        boolean isWord;
        Map<Character, Node> children = new HashMap<>();
    }

    private Node root = new Node();

    public WordDictionary() {
    }

    public void addWord(String word) {
        var cur = this.root;
        for (var letter: word.toCharArray()) {
            cur = cur.children.computeIfAbsent(letter, k -> new Node());
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        var nodes = List.of(this.root);
        for (var letter: word.toCharArray()) {
            var next = new ArrayList<Node>();
            for (var node: nodes) {
                if (letter == '.') {
                    for (var child: node.children.values()) {
                        next.add(child);
                    }
                } else {
                    if (node.children.containsKey(letter)) {
                        next.add(node.children.get(letter));
                    }
                }
            }
            if (next.isEmpty()) {
                return false;
            }
            nodes = next;
        }

        return nodes.stream().anyMatch(n -> n.isWord);
    }
}
