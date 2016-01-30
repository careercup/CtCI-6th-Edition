package chapter3

import (
	"fmt"
)

// Only including fixed stack size solution.
// Book states variable solution is too complex for an interview.

type SliceMultiStack struct {
	slice    []*stackNode // slice holding nodes, so we can set nils
	sizes    []int        // number of elements in each stack
	stacks   int          // number of stacks
	stackMax int          // size of each stack
}

func GetSliceMultiStack(stacks, stackSize int) *SliceMultiStack {
	slice := make([]*stackNode, stacks*stackSize)
	sizes := make([]int, stacks)
	return &SliceMultiStack{slice, sizes, stacks, stackSize}
}

func (s *SliceMultiStack) getMultiStackHead(stack int) int {
	return ((stack - 1) * s.stackMax) + s.sizes[(stack-1)] - 1
}

func (s *SliceMultiStack) Push(stack, value int) error {
	stackIndex := stack - 1
	if s.sizes[stackIndex] >= s.stackMax {
		return fmt.Errorf("Cannot push. Stack %d is full.", stack)
	}
	s.slice[s.getMultiStackHead(stack)+1] = &stackNode{value: value}
	s.sizes[stackIndex]++
	return nil
}

func (s *SliceMultiStack) Pop(stack int) (int, error) {
	if s.IsEmpty(stack) {
		return 0, fmt.Errorf("Cannot pop, stack is empty.")
	}
	ret := s.slice[s.getMultiStackHead(stack)].value
	s.slice[s.getMultiStackHead(stack)] = nil
	s.sizes[stack-1]--
	return ret, nil
}

func (s *SliceMultiStack) Peek(stack int) (int, error) {
	if s.IsEmpty(stack) {
		return 0, fmt.Errorf("Cannot peek, stack is empty.")
	}
	return s.slice[s.getMultiStackHead(stack)].value, nil
}

func (s *SliceMultiStack) IsEmpty(stack int) bool {
	return s.sizes[stack-1] == 0
	// alternative:
	// return s.slice[s.stackSize*stack] == nil
}
