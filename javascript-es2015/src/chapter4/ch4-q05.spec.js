import { expect } from 'chai';
import { Tree } from './helpers';
import * as funcs from './ch4-q05';

for (let key in funcs) {
  let func = funcs[key];

  describe('ch4-q05: ' + key, function() {

    beforeEach(function() {
      this.tree = new Tree();
    });

    it('throws error when tree is invalid', function() {
      expect(() => func(null)).to.throw('invalid tree');
      expect(() => func(undefined)).to.throw('invalid tree');
    });

    it('returns true for single node tree', function() {
      this.tree.add(11);
      expect(func(this.tree)).to.be.true;
    });

    it('returns true for larger BSTs', function() {
      // Tree class maintains BST property so this should be valid
      [100, 20, 10, 5, 1, 2, 3, 7, 8, 9, 15, 35, 25, 30, 45].forEach(v => this.tree.add(v));
      expect(func(this.tree)).to.be.true;
      [200, 150, 120, 115, 145, 130, 135, 160, 180, 175, 170, 165, 190].forEach(v => this.tree.add(v));
      expect(func(this.tree)).to.be.true;
      [220, 205, 210, 225, 230, 215, 240].forEach(v => this.tree.add(v));
      expect(func(this.tree)).to.be.true;
    });

    it('returns true for BST with duplicate values', function() {
      // Tree class maintains BST property so this should be valid
      [10, 10].forEach(v => this.tree.add(v));
      expect(func(this.tree)).to.be.true;
      [5, 10, 15, 20, 0, 5].forEach(v => this.tree.add(v));
      expect(func(this.tree)).to.be.true;
      [20, 5, 25, 0].forEach(v => this.tree.add(v));
      expect(func(this.tree)).to.be.true;
      [25, 30, 1, 2, 3, 4, 5].forEach(v => this.tree.add(v));
      expect(func(this.tree)).to.be.true;
    });

    it('returns correct value with simple trees', function() {
      [2, 1, 3].forEach(v => this.tree.add(v));
      expect(func(this.tree)).to.be.true;
      this.tree.root.left.val = 4;
      expect(func(this.tree)).to.be.false;

      this.tree.root = null;
      [100, 110, 120, 130].forEach(v => this.tree.add(v));
      expect(func(this.tree)).to.be.true;
      this.tree.root.right.right.val = 100;
      expect(func(this.tree)).to.be.false;
    });

    it('returns false for larger trees that are not BSTs', function() {
      // Tree class maintains BST property so this should be valid
      [20, 10, 5, 1, 2, 3, 7, 8, 9, 15, 35, 25, 30, 45].forEach(v => this.tree.add(v));
      // now we need to invalidate BST
      this.tree.root.val = 50;
      expect(func(this.tree)).to.be.false;
      this.tree.root = null;
      [200, 150, 120, 115, 145, 130, 135, 160, 180, 175, 170, 165, 190].forEach(v => this.tree.add(v));
      this.tree.root.left.left.val = 200;
      expect(func(this.tree)).to.be.false;
      this.tree.root.val = 100;
      expect(func(this.tree)).to.be.false;
      this.tree.root.left.right = 145;
      expect(func(this.tree)).to.be.false;
    });

  });

}
