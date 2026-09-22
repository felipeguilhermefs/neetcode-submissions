class HashTable {
    int size;
    int capacity;  
    Pair[] map;

    public HashTable(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.map = new Pair[capacity];
    }

    public void insert(int key, int value) {
        int index = this.hash(key);

        while (true) {
            if (this.map[index] == null) {
                this.map[index] = new Pair(key, value);
                this.size += 1;
                if (this.size >= this.capacity / 2) {
                    this.resize();
                }
                return;       
            } else if (this.map[index].key == key) {
                this.map[index].value = value;
                return;
            }
            index += 1;
            index = index % this.capacity;
        }    
    }

    public int get(int key) {
        int index = this.hash(key);
        while (this.map[index] != null) {
            if (this.map[index].key == key) {
                return this.map[index].value;
            }  
            index += 1;
            index = index % this.capacity;
        }    
        return -1;
    }

    public boolean remove(int key) {
        if (this.get(key) == -1) {
            return false;
        }
        
        int index = this.hash(key);
        while (true) {
            if (this.map[index].key == key) {
                // Removing an element using open-addressing actually causes a bug,
                // because we may create a hole in the list, and our get() may 
                // stop searching early when it reaches this hole.
                this.map[index] = null;
                this.size -= 1;
                return true;
            }    
            index += 1;
            index = index % this.capacity;
        }
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void resize() {
        this.capacity = 2 * this.capacity;
        Pair[] newMap = new Pair[this.capacity];

        Pair[] oldMap = this.map;
        this.map = newMap;
        this.size = 0;
        for (Pair p: oldMap) {
            if (p != null) {
                this.insert(p.key, p.value);
            }
        }
    }

    private int hash(int key) {
        return key % this.capacity;
    }

    class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
