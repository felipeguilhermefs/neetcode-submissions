class LRUCache {

    class Node {
        final int key;
        final int value;
        Node prev;
        Node next;

        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<Integer,Node>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.tail.next = this.head;
        this.head.prev = this.tail;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            var node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) remove(cache.get(key));

        var node = new Node(key, value);
        cache.put(key, node);
        insert(node);

        if (cache.size() > capacity) {
            var lru = tail.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    private void remove(Node node) {
        var prev = node.prev;
        var next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        var prev = head.prev;
        prev.next = node;
        node.prev = prev;
        node.next = head;
        head.prev = node;
    }
}
