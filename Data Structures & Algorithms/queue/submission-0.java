class Deque {

    private class Node {
        int value;
        Node prev;
        Node next;
        
        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        } 
    }

    private Node front;
    private Node back;

    public Deque() {
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void append(int value) {
        back = new Node(value, back, null);
        if (back.prev != null) {
            back.prev.next = back;
        }
        if (front == null) {
            front = back;
        }
    }

    public void appendleft(int value) {
        front = new Node(value, null, front);
        if (front.next != null) {
            front.next.prev = front;
        }

        if (back == null) {
            back = front;
        }
    }

    public int pop() {
        if (back == null) return -1;
        
        var value = back.value;
        if (front == back) {
            front = null;
            back = null;
        } else {
            back = back.prev;
            back.next = null;
        }
        return value;
    }

    public int popleft() {
        if (front == null) return -1;

        var value = front.value;
        
        if (front == back) {
            front = null;
            back = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        return value;
    }
}
