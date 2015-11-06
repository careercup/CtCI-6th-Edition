import { expect } from 'chai';
import * as helpers from './helpers';
import * as funcs from './ch2-q4';

for (let key in funcs) {
  let func = funcs[key];

  describe('ch2-q4: ' + key, function() {

    [
      {
        list: [5, 8, 7, 4, 9, 15, 30],
        value: 3,
        expected: [5, 8, 7, 4, 9, 15, 30]
      },
      {
        list: [5, 8, 7, 4, 9, 15, 30],
        value: 31,
        expected: [5, 8, 7, 4, 9, 15, 30]
      },
      {
        list: [5, 8, 3, 2, 7, 1, 4, 9, 15, 30],
        value: 2,
        expected: [1, 5, 8, 3, 2, 7, 4, 9, 15, 30]
      },
      {
        list: [5, 8, 3, 2, 7, 1, 4, 9, 15, 30],
        value: 7,
        expected: [5, 3, 2, 1, 4, 8, 7, 9, 15, 30]
      },
      {
        list: [4, 9, 15, 30, 5, 8, 3, 2, 2, 3, 7, 1, 15, 5, 6, 7],
        value: 6,
        expected: [4, 5, 3, 2, 2, 3, 1, 5, 9, 15, 30, 8, 7, 15, 6, 7]
      },
      {
        list: [4, 9, 15, 30, 5, 8, 3, 2, 2, 3, 7, 1, 15, 5, 6, 7],
        value: 17,
        expected: [4, 9, 15, 5, 8, 3, 2, 2, 3, 7, 1, 15, 5, 6, 7, 30]
      },
      {
        list: [4, 9, 15, 30, 5, 8, 20, 25, 20, 21, 21, 7, 1, 15, 5, 6, 7],
        value: 14,
        expected: [4, 9, 5, 8, 7, 1, 5, 6, 7, 15, 30, 20, 25, 20, 21, 21, 15]
      }
    ].forEach(context => {

      it(`partitioning list ${context.list} around ${context.value}`, function() {
        let list = helpers.arrayToLinkedList(context.list);
        expect(helpers.linkedListToArray(func(list, context.value))).to.eql(context.expected);
      });

    });

  });
}
