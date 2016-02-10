import { expect } from 'chai';
import { Tree } from './helpers';
import * as funcs from './ch4-q12';

for (let key in funcs) {
  let func = funcs[key];

  describe('ch4-q12: ' + key, function() {

    beforeEach(function() {
      this.tree = new Tree();
    });

    it('throws an error if tree is null or empty', function() {
      expect(() => func(null, 10)).to.throw('tree must be valid and non-empty');
      expect(() => func(this.tree)).to.throw('tree must be valid and non-empty');
    });

    it('returns 0 when no paths sum to value', function() {
      [10, 9, 11, 8, 7, 6].forEach(v => this.tree.add(v));
      expect(func(this.tree, 50)).to.eql(0);
      expect(func(this.tree, 5)).to.eql(0);
    });

    it('returns correct counts with balanced tree', function() {
      [8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15].forEach(v => this.tree.add(v));
      expect(func(this.tree, 1)).to.equal(1);
      expect(func(this.tree, 5)).to.equal(2);
      expect(func(this.tree, 10)).to.equal(2);
      expect(func(this.tree, 11)).to.equal(2);
    });

    it('returns correct counts with unbalanced tree', function() {
      [10, 8, 16, 4, 14, 22, 6, 12, 18, 5, 17, 19].forEach(v => this.tree.add(v));
      expect(func(this.tree, 10)).to.equal(2);
      expect(func(this.tree, 18)).to.equal(3);
    });

    it('returns correct counts with lots of paths that equal value', function() {
      [50, 10, 80, 40, 70, 150, 20, 30].forEach(v => this.tree.add(v));
      expect(func(this.tree, 50)).to.equal(3);
      expect(func(this.tree, 150)).to.equal(3);
    });

  });

}
