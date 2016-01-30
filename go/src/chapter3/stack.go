package chapter3

import (
	"errors"
)

type Stackable interface {
	Push(int)
	Pop() (int, error)
	Peek() (int, error)
	IsEmpty() bool
}

type Stack struct {
	top *stackNode
}

type stackNode struct {
	value int
	prev  *stackNode
}

func (s *Stack) Push(value int) {
	newNode := &stackNode{value: value}
	if s.top != nil {
		newNode.prev = s.top
	}
	s.top = newNode
}

func (s *Stack) Pop() (int, error) {
	if s.top == nil {
		return -1, errors.New("Cannot pop. Stack is empty.")
	}
	ret := s.top.value
	s.top = s.top.prev
	return ret, nil
}

func (s *Stack) Peek() (int, error) {
	if s.top == nil {
		return -1, errors.New("Cannot peek. Stack is empty.")
	}
	return s.top.value, nil
}

func (s *Stack) IsEmpty() bool {
	return s.top == nil
}
