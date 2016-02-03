package chapter3

import (
	"errors"
)

type QueueUsingStacks struct {
	older *Stack
	newer *Stack
}

func GetQueueUsingStacks() *QueueUsingStacks {
	return &QueueUsingStacks{&Stack{}, &Stack{}}
}

func (s *QueueUsingStacks) Add(value int) {
	s.newer.Push(value)
}

func (s *QueueUsingStacks) newToOld() {
	for {
		val, err := s.newer.Pop()
		if err != nil {
			break
		}
		s.older.Push(val)
	}
}

func (s *QueueUsingStacks) Remove() (int, error) {
	if s.older.IsEmpty() {
		if s.newer.IsEmpty() {
			return -1, errors.New("Cannot pop. QueueUsingStacks is empty.")
		}
		s.newToOld()
		val, err := s.older.Pop()
		if err != nil {
			return -1, err
		}
		return val, nil
	} else {
		val, err := s.older.Pop()
		if err != nil {
			return -1, err
		}
		return val, nil
	}
}

func (s *QueueUsingStacks) Peek() (int, error) {
	if s.older.IsEmpty() {
		if s.newer.IsEmpty() {
			return -1, errors.New("Cannot peek. QueueUsingStacks is empty.")
		}
		s.newToOld()
		val, err := s.older.Peek()
		if err != nil {
			return -1, err
		}
		return val, nil
	} else {
		val, err := s.older.Peek()
		if err != nil {
			return -1, err
		}
		return val, nil
	}
}

func (s *QueueUsingStacks) IsEmpty() bool {
	return s.newer.IsEmpty() && s.older.IsEmpty()
}
