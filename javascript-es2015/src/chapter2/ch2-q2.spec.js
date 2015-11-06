import { expect } from 'chai';
import * as helpers from './helpers';
import * as funcs from './ch2-q2';

for (let key in funcs) {
  let func = funcs[key];

  describe('ch2-q2: ' + key, function() {

    it('throws an error if list is not an array', function() {
      expect(() => func(null)).to.throw('invalid list');
      expect(() => func(undefined)).to.throw('invalid list');
    });

    it('throws an error if list is shorter than k', function() {
      expect(() => func(helpers.arrayToLinkedList([1]), 1)).to.throw('list is not long enough');
      expect(() => func(helpers.arrayToLinkedList([1, 2, 3]), 3)).to.throw('list is not long enough');
      expect(() => func(helpers.arrayToLinkedList([1, 2, 3]), 4)).to.throw('list is not long enough');
    });

    [
      {
        list: [5],
        k: 0
      },
      {
        list: [8, 5, 1],
        k: 0
      },
      {
        list: [8, 5, 1],
        k: 1
      },
      {
        list: [8, 5, 1],
        k: 2
      },
      {
        list: [8, 8, 9, 9, 9, 6, 6, 4, 4, 6, 6, 4, 4, 6, 9, 4, 8, 2, 3, 1],
        k: 8
      },
      {
        list: [8, 8, 9, 9, 9, 6, 6, 4, 4, 6, 6, 4, 4, 6, 9, 4, 8, 2, 3, 1],
        k: 16
      }
    ].forEach(context => {

      it(`can get the ${context.k}th to last element in ${context.list}`, function() {
        let list = helpers.arrayToLinkedList(context.list),
          expected = context.list[context.list.length - 1 - context.k];
        expect(func(list, context.k)).to.eql(expected);
      });

    });

  });
}
