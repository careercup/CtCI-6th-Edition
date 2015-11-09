import { expect } from 'chai';
import { Tree } from './helpers';
import * as funcs from './ch4-q08';

for (let key in funcs) {
  let func = funcs[key];

  describe('ch4-q08: ' + key, function() {

    beforeEach(function() {
      this.tree = new Tree();
    });

    it('throws an error if either node is null', function() {
      this.tree.add(1);
      expect(() => func(null, null)).to.throw('node1 and node2 must both be valid nodes');
      expect(() => func(this.tree.root, null)).to.throw('node1 and node2 must both be valid nodes');
      expect(() => func(null, this.tree.root)).to.throw('node1 and node2 must both be valid nodes');
    });

    it('returns right value for simple 3 node balanced tree', function() {
      [10, 9, 11].forEach(v => this.tree.add(v));
      expect(func(this.tree.root.left, this.tree.root.right)).to.equal(10);
      expect(func(this.tree.root, this.tree.root.right)).to.equal(10);
      expect(func(this.tree.root.left, this.tree.root)).to.equal(10);
    });

    it('returns correct values for larger balanced tree', function() {
      [8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15].forEach(v => this.tree.add(v));

      expect(func(this.tree.root.left.left.left, this.tree.root.left.left.left)).to.equal(1);
      expect(func(this.tree.root.left.left.left, this.tree.root.left.left.right)).to.equal(2);
      expect(func(this.tree.root.left.left.right, this.tree.root.left.left.left)).to.equal(2);

      expect(func(this.tree.root.left, this.tree.root.left)).to.equal(4);
      expect(func(this.tree.root.left.left.right, this.tree.root.left)).to.equal(4);
      expect(func(this.tree.root.left.left.right, this.tree.root.left.right)).to.equal(4);
      expect(func(this.tree.root.left.left.left, this.tree.root.left.right.left)).to.equal(4);
      expect(func(this.tree.root.left.left.left, this.tree.root.left.right.right)).to.equal(4);
      expect(func(this.tree.root.left.left.right, this.tree.root.left.right.left)).to.equal(4);
      expect(func(this.tree.root.left.left.right, this.tree.root.left.right.right)).to.equal(4);

      expect(func(this.tree.root.left.left.right, this.tree.root)).to.equal(8);
      expect(func(this.tree.root.left.left.right, this.tree.root.right)).to.equal(8);
      expect(func(this.tree.root.left.left.right, this.tree.root.right.right)).to.equal(8);
      expect(func(this.tree.root.left.left.right, this.tree.root.right.left.left)).to.equal(8);
      expect(func(this.tree.root.left.left.right, this.tree.root.right.left.right)).to.equal(8);
      expect(func(this.tree.root.left.left.right, this.tree.root.right.right.left)).to.equal(8);
      expect(func(this.tree.root.left.left.right, this.tree.root.right.right.right)).to.equal(8);
    });

  });

}
