import { expect } from 'chai';
import * as classes from './ch4-q11';

function runSampling(values, obj, samples) {
  for (let i = 0; i < samples; ++i) {
    let val = obj.randomNode().val;
    values[val - 1] = true;
  }
}

for (let key in classes) {
  let Class = classes[key];

  describe('ch4-q11: ' + key, function() {

    beforeEach(function() {
      this.obj = new Class();
    });

    it('returns single number when only one item in tree', function() {
      this.obj.insert(1);
      expect(this.obj.randomNode().val).to.equal(1);
      expect(this.obj.randomNode().val).to.equal(1);
      expect(this.obj.randomNode().val).to.equal(1);
    });

    [
      {
        desc: 'balanced',
        values: [8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15]
      },
      {
        desc: 'left imbalanced',
        values: [15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
      },
      {
        desc: 'right imbalanced',
        values: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
      },
      {
        desc: 'random',
        values: [3, 15, 2, 1, 8, 4, 5, 7, 6, 14, 13, 12, 10, 11, 9]
      }
    ].forEach(context => {

      describe(`with ${context.desc} tree`, function () {

        beforeEach(function() {
          context.values.forEach(v => this.obj.insert(v));
        });

        it('returns random number in range', function() {
          expect(this.obj.randomNode().val).to.be.within(1, 15);
        });

        it('returns all numbers in range over 1000 calls', function() {
          let gotValue = (new Array(15)).fill(false);
          runSampling(gotValue, this.obj, 1000);
          expect(gotValue.every(v => v)).to.be.true;
        });

        it('returns valid numbers in range over 1000 calls where deletions are done', function() {
          let pickedValues;

          this.obj.delete(1);
          pickedValues = (new Array(15)).fill(false);
          runSampling(pickedValues, this.obj, 1000);
          expect(pickedValues).to.eql([false, true, true, true, true, true, true,
            true, true, true, true, true, true, true, true]);

          this.obj.delete(8);
          pickedValues = (new Array(15)).fill(false);
          runSampling(pickedValues, this.obj, 1000);
          expect(pickedValues).to.eql([false, true, true, true, true, true, true,
            false, true, true, true, true, true, true, true]);

          this.obj.delete(12);
          pickedValues = (new Array(15)).fill(false);
          runSampling(pickedValues, this.obj, 1000);
          expect(pickedValues).to.eql([false, true, true, true, true, true, true,
            false, true, true, true, false, true, true, true]);
        });

      });

    });

  });

}
