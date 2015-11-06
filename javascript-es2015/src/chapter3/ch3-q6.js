'use strict';

/**
 * Uses two different queues one for dogs and one for cats. Each entry is
 * assigned a unique identifier which allows dequeueAny to determine which of
 * the two queues to dequeue an item from.
 *
 * N = number of animals
 * Time: enqueue O(1), dequeue O(1), dequeueAny O(1)
 * Additional space: enqueue O(N), dequeue O(1), dequeueAny O(1)
 * Additional space required to hold unique id per animal.
 */
export class AnimalShelter {
  constructor() {
    this._dogs = [];
    this._cats = [];
    this._id = 0;
  }

  enqueueCat(name) {
    this._cats.push({
      name: name,
      id: ++this._id
    });
  }

  enqueueDog(name) {
    this._dogs.push({
      name: name,
      id: ++this._id
    });
  }

  dequeueAny() {
    let dogId = this._dogs.length > 0 ? this._dogs[0].id : Number.POSITIVE_INFINITY,
      catId = this._cats.length > 0 ? this._cats[0].id : Number.POSITIVE_INFINITY;

    if (dogId !== Number.POSITIVE_INFINITY || catId !== Number.POSITIVE_INFINITY) {
      if (dogId < catId) {
        return this._dogs.shift().name;
      }
      else {
        return this._cats.shift().name;
      }
    }
  }

  dequeueCat() {
    return this._cats.shift().name;
  }

  dequeueDog() {
    return this._dogs.shift().name;
  }
}
