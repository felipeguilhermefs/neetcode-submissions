class MinStack {

    private final Stack<Integer> items;
    private final Stack<Integer> mins;

    public MinStack() {
        items = new Stack<>();
        mins = new Stack<>();
    }
    
    public void push(int val) {
        items.push(val);
        mins.push(mins.isEmpty() || mins.peek() > val ? val : mins.peek());
    }
    
    public void pop() {
        items.pop();
        mins.pop();
    }
    
    public int top() {
        return items.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}
