import { expect } from 'chai';
import * as helpers from './helpers';
import * as funcs from './ch2-q8';

for (let key in funcs) {
  let func = funcs[key];

  describe('ch2-q8: ' + key, function() {

    beforeEach(function() {
      this.list = helpers.createLinkedList();
    });

    it('returns null with empty list', function() {
      expect(func(this.list.head)).to.be.null;
    });

    it('returns null when there is no loop', function() {
      helpers.push(this.list, 1, 2, 3, 4, 5, 6);
      expect(func(this.list.head)).to.be.null;
    });

    it('returns node when there is a loop 1', function() {
      helpers.push(this.list, 1, 2, 3, 4, 5, 6);
      let node = this.list.head;
      this.list.tail.next = node;
      expect(func(this.list.head)).to.equal(node);
    });

    it('returns node when there is a loop 2', function() {
      helpers.push(this.list, 1, 2, 3, 4, 5, 6);
      let node = this.list.head.next.next.next;
      this.list.tail.next = node;
      expect(func(this.list.head)).to.equal(node);
    });

    it('returns node when there is a loop 3', function() {
      helpers.push(this.list, 1, 2, 3, 4, 5, 6);
      let node = this.list.tail;
      this.list.tail.next = node;
      expect(func(this.list.head)).to.equal(node);
    });

  });
}
