class LinkedList {

    private class Node {
        int value;
        Node next;
        
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    public LinkedList() {
    }

    public int get(int index) {
        var cur = head;
        var i = 0;
        while (cur != null) {
            if (i == index) return cur.value;
            i++;
            cur = cur.next;
        }

        return -1;
    }

    public void insertHead(int val) {
        head = new Node(val, head);
        if (tail == null) tail = head;
    }

    public void insertTail(int val) {
        if (tail == null) {
            insertHead(val);
        } else {
            tail.next = new Node(val, null);
            tail = tail.next;
        }
    }

    public boolean remove(int index) {
        Node prev = null;
        var cur = head;
        var i = 0;
        while (cur != null) {
            if (i == index) {
                if (prev == null) {
                    head = cur.next;
                    if (head == null) {
                        tail = null;
                    }
                    return true;
                }
                
                if (cur == tail) {
                    tail = prev;
                }
                prev.next = cur.next;
                return true;
            }
            i++;
            prev = cur;
            cur = cur.next;
        }

        return false;
    }

    public ArrayList<Integer> getValues() {
        var values = new ArrayList<Integer>();
        var cur = head;
        while (cur != null) {
            values.add(cur.value);
            cur = cur.next;
        }
        return values;
    }
}
