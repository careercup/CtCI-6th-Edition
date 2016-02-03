package chapter3

import (
	"errors"
)

// Sort stack based on using two stacks, where one is always in order
// and the other is used for temp storage during sorting.
type SortStack struct {
	sorted *Stack
	temp   *Stack
}

func GetSortStack() *SortStack {
	return &SortStack{&Stack{}, &Stack{}}
}

func (s *SortStack) Push(value int) {
	// Pop values until we empty the list, or find a larger value.
	if !s.sorted.IsEmpty() {
		for {
			peek, err := s.sorted.Peek()
			if err != nil {
				break
			}
			if peek < value {
				pop, _ := s.sorted.Pop()
				s.temp.Push(pop)
			} else {
				break
			}
		}
	}
	s.sorted.Push(value)
	// Put back any values that were smaller.
	if !s.temp.IsEmpty() {
		for {
			pop, err := s.temp.Pop()
			if err != nil {
				break
			}
			s.sorted.Push(pop)
		}
	}
}

func (s *SortStack) Pop() (int, error) {
	if s.sorted.IsEmpty() {
		return -1, errors.New("Cannot pop. Stack is empty.")
	}
	val, err := s.sorted.Pop()
	if err != nil {
		return -1, err
	}
	return val, nil
}

// Peek is also Min in SortStack.
func (s *SortStack) Peek() (int, error) {
	if s.sorted.IsEmpty() {
		return -1, errors.New("Cannot peek. Stack is empty.")
	}
	val, err := s.sorted.Peek()
	if err != nil {
		return -1, err
	}
	return val, nil
}

func (s *SortStack) IsEmpty() bool {
	return s.sorted.IsEmpty()
}
