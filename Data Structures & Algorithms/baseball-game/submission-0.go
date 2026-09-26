func push(stack []int, top, val int) ([]int, int) {
	if top < len(stack) {
		stack[top] = val
	} else {
		stack = append(stack, val)
	}

	top++

	return stack, top
}

func calPoints(operations []string) int {
	var rec []int

	top := 0

	for _, op := range operations {
		fmt.Println(op, top, rec)
		if op == "C" {
			top--
		} else if op == "D" {
			rec, top = push(rec, top, rec[top-1] * 2)
		} else if op == "+" {
			rec, top = push(rec, top, rec[top-1] + rec[top-2])
		} else {
			val, _ := strconv.Atoi(op)
			rec, top = push(rec, top, val)
		}
	}

	res := 0
	for i := 0; i < top; i++ {
		res += rec[i]
	}
	return res
}
