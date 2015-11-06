import { expect } from 'chai';
import * as classes from './ch3-q4';

for (let key in classes) {
  let Queue = classes[key];

  describe('ch3-q4: ' + key, function() {

    beforeEach(function() {
      this.queue = new Queue();
    });

    it('dequeue throws error when queue is empty', function () {
      expect(() => this.queue.dequeue()).to.throw('queue is empty');
    });

    it('can enqueue and dequeue items', function () {
      for (let i = 0; i < 10; ++i) {
        let j;
        for (j = 1; j <= 100; ++j) {
          this.queue.enqueue(j);
        }
        for (j = 1; j <= 100; ++j) {
          expect(this.queue.dequeue()).to.equal(j);
        }
      }
    });

    it('can do alternating enqueue and dequeues', function() {
      this.queue.enqueue(10);
      this.queue.enqueue(20);
      this.queue.enqueue(30);
      expect(this.queue.dequeue()).to.equal(10);
      this.queue.enqueue(40);
      expect(this.queue.dequeue()).to.equal(20);
      expect(this.queue.dequeue()).to.equal(30);
      expect(this.queue.dequeue()).to.equal(40);
      this.queue.enqueue(50);
      this.queue.enqueue(60);
      this.queue.enqueue(70);
      expect(this.queue.dequeue()).to.equal(50);
      expect(this.queue.dequeue()).to.equal(60);
      this.queue.enqueue(80);
      expect(this.queue.dequeue()).to.equal(70);
      this.queue.enqueue(90);
      expect(this.queue.dequeue()).to.equal(80);
      expect(this.queue.dequeue()).to.equal(90);
    });

  });
}
