package chapter3

import (
	"testing"
)

func TestPetShelter(t *testing.T) {
	ps := GetPetShelter()
	ps.enqueue("lucky", DogType)
	ps.enqueue("spot", DogType)
	ps.enqueue("snowball", CatType)
	var i *PetInfo
	var err error
	i, err = ps.dequeueAny()
	if err != nil {
		t.Fatalf("Unexpected error: %v\n", err)
	}
	if i.petType != DogType || i.name != "lucky" {
		t.Fatalf("Expected: lucky, actual: %d\n", i.name)
	}
	i, err = ps.dequeueDog()
	if err != nil {
		t.Fatalf("Unexpected error: %v\n", err)
	}
	if i.petType != DogType || i.name != "spot" {
		t.Fatalf("Expected: spot, actual: %d\n", i.name)
	}
	i, err = ps.dequeueCat()
	if err != nil {
		t.Fatalf("Unexpected error: %v\n", err)
	}
	if i.petType != CatType || i.name != "snowball" {
		t.Fatalf("Expected: snowball, actual: %d\n", i.name)
	}
}
