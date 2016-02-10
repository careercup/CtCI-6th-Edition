import { expect } from 'chai';
import * as classes from './ch3-q2';

for (let key in classes) {
  let Stack = classes[key];

  describe('ch3-q2: ' + key, function() {

    beforeEach(function() {
      this.stack = new Stack();
    });

    it('min is undefined when stack is empty', function() {
      expect(this.stack.isEmpty()).to.be.true;
      expect(this.stack.min()).to.be.undefined;
    });

    it('can push values in ascending order and min stays the same', function() {
      let values = [2, 4, 6, 8, 10, 12];

      values.forEach(v => {
        this.stack.push(v);
        expect(this.stack.min()).to.equal(2);
      });

      values.reverse().forEach(v => {
        expect(this.stack.min()).to.equal(2);
        expect(this.stack.pop()).to.equal(v);
      });

      expect(this.stack.min()).to.be.undefined;
    });

    it('can push values in descending order and min is updated', function() {
      let values = [12, 10, 8, 6, 4, 2];

      values.forEach(v => {
        this.stack.push(v);
        expect(this.stack.min()).to.equal(v);
      });

      values.reverse().forEach((v) => {
        expect(this.stack.min()).to.equal(v);
        expect(this.stack.pop()).to.equal(v);
      });

      expect(this.stack.min()).to.be.undefined;
    });

  });
}
