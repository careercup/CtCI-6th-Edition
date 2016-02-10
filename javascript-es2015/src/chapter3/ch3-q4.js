'use strict';

/**
 * Queues and Stacks have different orders for extracting items. To create a
 * queue with stacks we have two stacks, one for inserting items and one for
 * extracting them. When dequeuing an item if the extract stack is empty we
 * use queue operations to pop all the items off the insert stack onto the
 * extract stack which will now be in the right order for a queue.
 *
 * N = |MyQueue|
 * Time: enqueue O(1), dequeue O(N)
 * Additional space: O(N) - to hold the input items
 */
export class MyQueue {
  constructor() {
    this.eStack = [];
    this.dStack = [];
  }

  enqueue(value) {
    this.eStack.push(value);
  }

  dequeue() {
    if (this.dStack.length === 0 && this.eStack.length === 0) {
      throw new Error('queue is empty');
    }
    if (this.dStack.length === 0) {
      while (this.eStack.length > 0) {
        this.dStack.push(this.eStack.pop());
      }
    }
    return this.dStack.pop();
  }
}
