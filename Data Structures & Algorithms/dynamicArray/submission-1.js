class DynamicArray {
    /**
     * @constructor
     * @param {number} capacity
     */
    constructor(capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.storage = [];
    }

    /**
     * @param {number} i
     * @returns {number}
     */
    get(i) {
        return this.storage[i];
    }

    /**
     * @param {number} i
     * @param {number} n
     * @returns {void}
     */
    set(i, n) {
        this.storage[i] = n;
    }

    /**
     * @param {number} n
     * @returns {void}
     */
    pushback(n) {
        if (this.capacity == this.size) this.resize();
        this.storage[this.size] = n;
        this.size++;
    }

    /**
     * @returns {number}
     */
    popback() {
        if (this.size > 0) this.size--;
        return this.storage[this.size];
    }

    /**
     * @returns {void}
     */
    resize() {
        this.capacity *= 2;
        const newStorage = [];
        for (let i=0; i<this.size; i++) {
            newStorage[i] = this.storage[i];
        }
        this.storage = newStorage;
    }

    /**
     * @returns {number}
     */
    getSize() {
        return this.size;
    }

    /**
     * @returns {number}
     */
    getCapacity() {
        return this.capacity;
    }
}
