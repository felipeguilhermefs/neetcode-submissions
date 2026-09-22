class PrefixTree {

    private class Node {
         boolean isWord;
         Map<Character, Node> children = new HashMap<>();
    }

    private Node root;

    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
        var cur = root;
        for (var letter: word.toCharArray()) {
            cur = cur.children.computeIfAbsent(letter, k -> new Node());
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        var cur = root;
        for (var letter: word.toCharArray()) {
            cur = cur.children.get(letter);
            if (cur == null) {
                return false;
            }
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        var cur = root;
        for (var letter: prefix.toCharArray()) {
            cur = cur.children.get(letter);
            if (cur == null) {
                return false;
            }
        }
        return true;
    }
}
