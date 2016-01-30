package chapter3

import (
	"errors"
)

type MinStack struct {
	top *stackNode
	min *Stack
}

func GetMinStack() *MinStack {
	return &MinStack{min: &Stack{}}
}

func (s *MinStack) Push(value int) {
	newNode := &stackNode{value: value}
	if s.top != nil {
		newNode.prev = s.top
		// Set min
		min, _ := s.min.Peek()
		if value < min {
			s.min.Push(value)
		} else {
			s.min.Push(min)
		}
	} else {
		s.min.Push(value)
	}
	s.top = newNode
}

func (s *MinStack) Pop() (int, error) {
	if s.top == nil {
		return -1, errors.New("Cannot pop. Stack is empty.")
	}
	s.min.Pop()
	ret := s.top.value
	s.top = s.top.prev
	return ret, nil
}

func (s *MinStack) Peek() (int, error) {
	if s.top == nil {
		return -1, errors.New("Cannot peek. Stack is empty.")
	}
	return s.top.value, nil
}

func (s *MinStack) Min() (int, error) {
	if s.top == nil {
		return -1, errors.New("Cannot min. Stack is empty.")
	}
	return s.min.Peek()
}

func (s *MinStack) IsEmpty() bool {
	return s.top == nil
}
