import { expect } from 'chai';
import * as helpers from './helpers';
import * as funcs from './ch2-q1';

for (let key in funcs) {
  let func = funcs[key];

  describe('ch2-q1: ' + key, function() {

    it('returns input if falsy', function() {
      expect(func(null)).to.be.null;
      expect(func(undefined)).to.be.undefined;
    });

    [
      {
        list: [5],
        expected: [5]
      },
      {
        list: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        expected: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
      },
      {
        list: [5, 5, 5, 5, 5],
        expected: [5]
      },
      {
        list: [2, 4, 5, 4, 5, 4, 6, 7, 6, 8],
        expected: [2, 4, 5, 6, 7, 8]
      },
      {
        list: [8, 6, 8, 6],
        expected: [8, 6]
      },
      {
        list: [8, 8, 9, 9, 9, 6, 6, 4, 4, 6, 6, 4, 4, 6, 9, 4, 8, 2, 3, 1],
        expected: [8, 9, 6, 4, 2, 3, 1]
      }
    ].forEach(context => {

      it(`list ${context.list} correctly updated to ${context.expected}`, function() {
        let list = helpers.arrayToLinkedList(context.list);
        func(list);
        expect(helpers.linkedListToArray(list)).to.eql(context.expected);
      });

    });

  });
}
