type MinStack struct {
	items []int
	min int
}

func Constructor() MinStack {
	return MinStack{[]int{}, math.MaxInt64}
}

func (this *MinStack) Push(val int) {
	if len(this.items) == 0 {
		this.items = append(this.items, 0)
		this.min = val
	} else {
		this.items = append(this.items, val - this.min)
		if val < this.min {
			this.min = val
		}
	}
}

func (this *MinStack) Pop() {
	pop := this.items[len(this.items)-1]
	this.items = this.items[:len(this.items)-1]
	if pop < 0 {
		this.min -= pop
	}
}

func (this *MinStack) Top() int {
	top := this.items[len(this.items)-1]
	if top > 0 {
		return top + this.min
	}
	return this.min
}

func (this *MinStack) GetMin() int {
	return this.min
}
