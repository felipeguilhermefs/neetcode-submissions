class TreeMap {
    private class Node {
        int key;
        int val;
        Node left;
        Node right;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node root;

    public TreeMap() {
    }

    public void insert(int key, int val) {
        root = insert(root, key, val);
    }

    private Node insert(Node node, int key, int val) {
        if (node == null) return new Node(key, val);

        if (key < node.key) node.left = insert(node.left, key, val);
        else if (key > node.key) node.right = insert(node.right, key, val);
        else node.val = val;
        return node;
    }

    public int get(int key) {
        var cur = root;
        while(cur != null) {
            if (cur.key == key) return cur.val;
            if (cur.key > key) cur = cur.left;
            else cur = cur.right;
        } 
        return -1;
    }

    public int getMin() {
        var min = minNode(root);
        return min != null ? min.val : -1;
    }

    private Node minNode(Node node) {
        var cur = node;
        while (cur != null) {
            if (cur.left == null) return cur;
            else cur = cur.left;
        }
        return null;
    }

    public int getMax() {
        var cur = root;
        while (cur != null) {
            if (cur.right == null) return cur.val;
            else cur = cur.right;
        }
        return -1;
    }

    public void remove(int key) {
        root = remove(root, key);
    }

    public Node remove(Node node, int key) {
        if (node == null) return null;

        if (key > node.key) {
            node.right = remove(node.right, key);
        } else if (key < node.key) {
            node.left = remove(node.left, key);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            
            var min = minNode(node.right);
            node.key = min.key;
            node.val = min.val;

            node.right = remove(node.right, min.key);
        }

        return node;
    }

    public List<Integer> getInorderKeys() {
        var res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    private void inorder(Node node, List<Integer> values) {
        if (node != null) {
            inorder(node.left, values);
            values.add(node.key);
            inorder(node.right, values);    
        }
    } 
}
