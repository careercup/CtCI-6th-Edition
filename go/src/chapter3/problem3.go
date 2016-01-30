package chapter3

import (
	"errors"
	"fmt"
)

// Approaching this problem with the "stacks don't have to be at capacity"
// idea. This means that when we popAt, the target stack becomes the
// next stack to be targeted by push.
type SetOfStacks struct {
	stacks   []*Stack
	sizes    []int
	stackMax int
	curStack int
}

func GetSetOfStacks(max int) *SetOfStacks {
	return &SetOfStacks{
		[]*Stack{&Stack{}},
		[]int{0},
		max,
		0,
	}
}

func (s *SetOfStacks) Push(value int) {
	for s.sizes[s.curStack] == s.stackMax {
		s.curStack++
		if s.curStack >= len(s.sizes) {
			s.sizes = append(s.sizes, 0)
			s.stacks = append(s.stacks, &Stack{})
		}
	}
	s.stacks[s.curStack].Push(value)
	s.sizes[s.curStack]++
}

func (s *SetOfStacks) Pop() (int, error) {
	if s.IsEmpty() {
		return -1, errors.New("Cannot pop. SetOfStacks is empty.")
	}
	val, err := s.stacks[s.curStack].Pop()
	if err != nil {
		return 0, err
	}
	s.sizes[s.curStack]--
	if s.sizes[s.curStack] == 0 {
		s.curStack--
	}
	return val, nil
}

func (s *SetOfStacks) PopAt(stack int) (int, error) {
	stackIndex := stack - 1
	if s.sizes[stackIndex] == 0 {
		return -1, fmt.Errorf("Cannot popAt. Stack %d is empty.", stackIndex)
	}
	val, err := s.stacks[stackIndex].Pop()
	s.sizes[stackIndex]--
	if stackIndex < s.curStack {
		s.curStack = stackIndex
	}
	if err != nil {
		return 0, nil
	}
	return val, nil
}

func (s *SetOfStacks) Peek() (int, error) {
	if s.IsEmpty() {
		return -1, errors.New("Cannot pop. SetOfStacks is empty.")
	}
	val, err := s.stacks[s.curStack].Pop()
	if err != nil {
		return 0, err
	}
	return val, nil
}

func (s *SetOfStacks) IsEmpty() bool {
	return s.sizes[s.curStack] == 0
}
