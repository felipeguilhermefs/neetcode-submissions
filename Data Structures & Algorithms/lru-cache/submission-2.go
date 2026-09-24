type LRUNode struct {
	key int
	value int
	prev *LRUNode
	next *LRUNode
}
type LRUCache struct {
	capacity int
	cache map[int]*LRUNode
	head *LRUNode
	tail *LRUNode
}

func Constructor(capacity int) LRUCache {
	head := &LRUNode{-1, -1, nil, nil}
	tail := &LRUNode{-1, -1, head, nil}
	head.next = tail
	cache := make(map[int]*LRUNode)
	return LRUCache{capacity, cache, head, tail}
}

func (this *LRUCache) Get(key int) int {
	if node, ok := this.cache[key]; ok {
		this.remove(node)
		this.add(node)
		return node.value
	}
    return -1
}

func (this *LRUCache) Put(key int, value int) {
	if node, ok := this.cache[key]; ok {
		this.remove(node)
		node.value = value
		this.add(node)
		this.cache[key] = node
		return
	}
    
	if len(this.cache) >= this.capacity {
		last := this.tail.prev
		this.remove(last)
		delete(this.cache, last.key)
	} 
	
	node := &LRUNode{key, value, nil, nil}
	this.add(node)
	this.cache[key] = node
}

func (this *LRUCache) add(node *LRUNode) {
	tmp := this.head.next
	this.head.next = node
	node.next = tmp
	node.prev = this.head
	tmp.prev = node
}

func (this *LRUCache) remove(node *LRUNode) {
	node.prev.next = node.next
	node.next.prev = node.prev
}
