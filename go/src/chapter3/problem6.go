package chapter3

import (
	"errors"
	"time"
)

// Pet queue type, using PetInfo instead of int.
// Would be much easier if Go had generics.

type PetInfo struct {
	petType PetType
	name    string
	arrived time.Time
}

type PetType int

const (
	DogType PetType = iota
	CatType
)

type PetQueue struct {
	head, tail *petQueueNode
}

type petQueueNode struct {
	info       *PetInfo
	prev, next *petQueueNode
}

func (s *PetQueue) Add(name string, petType PetType) {
	newNode := &petQueueNode{
		info: &PetInfo{
			name:    name,
			petType: petType,
			arrived: time.Now(),
		},
	}
	if s.tail != nil {
		newNode.prev = s.tail
		s.tail.next = newNode
	}
	s.tail = newNode
	if s.head == nil {
		s.head = newNode
	}
}

func (s *PetQueue) Remove() (*PetInfo, error) {
	if s.head == nil {
		return nil, errors.New("Cannot pop. PetQueue is empty.")
	}
	info := s.head.info
	s.head = s.head.next
	if s.head != nil {
		s.head.prev = nil
	}
	return info, nil
}

func (s *PetQueue) Peek() (*PetInfo, error) {
	if s.head == nil {
		return nil, errors.New("Cannot peek. PetQueue is empty.")
	}
	return s.head.info, nil
}

func (s *PetQueue) IsEmpty() bool {
	return s.head == nil
}

// Simple approach using two queues: one for dogs, one for cats.
// To find the oldest, we just check the oldest from each queue.

type PetShelter struct {
	dogs, cats *PetQueue
}

func GetPetShelter() *PetShelter {
	return &PetShelter{&PetQueue{}, &PetQueue{}}
}

func (ps *PetShelter) enqueue(name string, petType PetType) {
	if petType == DogType {
		ps.dogs.Add(name, petType)
	} else {
		ps.cats.Add(name, petType)
	}
}

func (ps *PetShelter) dequeueDog() (*PetInfo, error) {
	info, err := ps.dogs.Remove()
	if err != nil {
		return nil, err
	}
	return info, nil
}

func (ps *PetShelter) dequeueCat() (*PetInfo, error) {
	info, err := ps.cats.Remove()
	if err != nil {
		return nil, err
	}
	return info, nil
}

func (ps *PetShelter) dequeueAny() (*PetInfo, error) {
	dog, dErr := ps.dogs.Peek()
	if dErr != nil {
		return nil, dErr
	}
	cat, cErr := ps.cats.Peek()
	if cErr != nil {
		return nil, cErr
	}
	if cat.arrived.Before(dog.arrived) {
		ps.cats.Remove()
		return cat, nil
	} else {
		ps.dogs.Remove()
		return dog, nil
	}
}
