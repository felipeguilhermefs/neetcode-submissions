class DynamicArray {

    private int[] storage;
    private int capacity;
    private int size;

    public DynamicArray(int capacity) {
        this.storage = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int i) {
        return storage[i];
    }

    public void set(int i, int n) {
        storage[i] = n;
    }

    public void pushback(int n) {
        if (size == capacity) resize();
        storage[size] = n;
        size++;
    }

    public int popback() {
        if (size > 0) size--;
        return storage[size];
    }

    private void resize() {
        capacity *= 2;
        int[] newStorage = new int[capacity];

        for(int i = 0; i < size; i++) {
            newStorage[i] = storage[i];
        }

        storage = newStorage;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
