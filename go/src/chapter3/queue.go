package chapter3

import (
	"errors"
)

type Queueable interface {
	Add(int)
	Remove() (int, error)
	Peek() (int, error)
	IsEmpty() bool
}

type Queue struct {
	head, tail *queueNode
}

type queueNode struct {
	value      int
	prev, next *queueNode
}

func (s *Queue) Add(value int) {
	newNode := &queueNode{value: value}
	if s.tail != nil {
		newNode.prev = s.tail
		s.tail.next = newNode
	}
	s.tail = newNode
	if s.head == nil {
		s.head = newNode
	}
}

func (s *Queue) Remove() (int, error) {
	if s.head == nil {
		return -1, errors.New("Cannot pop. Queue is empty.")
	}
	ret := s.head.value
	s.head = s.head.next
	if s.head != nil {
		s.head.prev = nil
	}
	return ret, nil
}

func (s *Queue) Peek() (int, error) {
	if s.head == nil {
		return -1, errors.New("Cannot peek. Queue is empty.")
	}
	return s.head.value, nil
}

func (s *Queue) IsEmpty() bool {
	return s.head == nil
}
