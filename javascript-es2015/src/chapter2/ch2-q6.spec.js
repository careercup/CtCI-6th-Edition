import { expect } from 'chai';
import * as helpers from './helpers';
import * as funcs from './ch2-q6';

for (let key in funcs) {
  let func = funcs[key];

  describe('ch2-q6: ' + key, function() {

    [
      [1, 2, 1],
      [1, 1],
      [2, 1, 3, 3, 1, 2],
      [2, 1, 3, 8, 9, 16, 16, 9, 8, 3, 1, 2],
      [2, 1, 3, 8, 9, 16, 11, 16, 9, 8, 3, 1, 2]
    ].forEach(arg => {

      it(`returns true for list ${arg}`, function() {
        let list = helpers.arrayToLinkedList(arg);
        expect(func(list)).to.be.true;
        // verify list is umodified
        expect(helpers.linkedListToArray(list)).to.eql(arg);
      });

    });

    [
      [1, 2, 2],
      [2, 1],
      [2, 1, 5, 4, 3, 2]
    ].forEach(arg => {

      it(`returns false for list ${arg}`, function() {
        let list = helpers.arrayToLinkedList(arg);
        expect(func(list)).to.be.false;
        // verify list is umodified
        expect(helpers.linkedListToArray(list)).to.eql(arg);
      });

    });

  });
}
