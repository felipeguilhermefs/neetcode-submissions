type MinStack struct {
	items []int
	mins []int
}

func Constructor() MinStack {
	return MinStack{[]int{}, []int{}}
}

func (this *MinStack) Push(val int) {
	if len(this.mins) == 0 {
		this.mins = append(this.mins, val)
	} else {
		min := this.mins[len(this.mins)-1]
		if val < min {
			min = val
		}
		this.mins = append(this.mins, min)
	}

	this.items = append(this.items, val)
}

func (this *MinStack) Pop() {
	this.items = this.items[:len(this.items)-1]
	this.mins = this.mins[:len(this.mins)-1]
}

func (this *MinStack) Top() int {
	return this.items[len(this.items)-1]
}

func (this *MinStack) GetMin() int {
	return this.mins[len(this.mins)-1]
}
