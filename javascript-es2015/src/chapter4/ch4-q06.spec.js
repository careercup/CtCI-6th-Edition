import { expect } from 'chai';
import { Tree } from './helpers';
import * as funcs from './ch4-q06';

for (let key in funcs) {
  let func = funcs[key];

  describe('ch4-q06: ' + key, function() {

    beforeEach(function() {
      this.tree = new Tree();
    });

    it('throws an error if node is null', function() {
      expect(() => func(null)).to.throw('node cannot be null');
    });

    it('returns undefined for root of single node tree', function() {
      this.tree.add(10);
      expect(func(this.tree.root)).to.be.undefined;
    });

    it('returns right value for simple 3 node balanced tree', function() {
      [10, 9, 11].forEach(v => this.tree.add(v));
      expect(func(this.tree.root.left)).to.equal(10);
      expect(func(this.tree.root)).to.equal(11);
      expect(func(this.tree.root.right)).to.be.undefined;
    });

    it('returns correct values for larger balanced tree', function() {
      [8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15].forEach(v => this.tree.add(v));

      expect(func(this.tree.root.left.left.left)).to.equal(2);
      expect(func(this.tree.root.left.left.right)).to.equal(4);
      expect(func(this.tree.root.left.right.left)).to.equal(6);
      expect(func(this.tree.root.left.right.right)).to.equal(8);

      expect(func(this.tree.root.right.left.left)).to.equal(10);
      expect(func(this.tree.root.right.left.right)).to.equal(12);
      expect(func(this.tree.root.right.right.left)).to.equal(14);
      expect(func(this.tree.root.right.right.right)).to.be.undefined;
    });

  });

}
