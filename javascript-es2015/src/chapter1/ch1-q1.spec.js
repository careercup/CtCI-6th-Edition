import { expect } from 'chai';
import { hasUniqueCharactersSet, hasUniqueCharactersSort } from './ch1-q1';

let funcs = {
  hasUniqueCharactersSet,
  hasUniqueCharactersSort
};

for (let key in funcs) {
  let func = funcs[key];
  describe('ch1-q1: ' + key, function() {

    [
      'abcdefghi',
      'jklpoiuqwerzxcvmnsadf',
      '1234567890',
      'AaBbCcDdeFg1234567890(*&^%$#@!)'
    ].forEach(s => {
      it(`returns true for unique string: ${s}`, function() {
        expect(func(s)).to.be.true;
      });
    });

    [
      'abcadef',
      'aaaaaaaaaa',
      'abcdefghijklmnopqrstuvwxyza',
      '1234567890asdklf1',
      '!@#$%^&*()(*#($&#(*$&#*($&#()))))'
    ].forEach(s => {
      it(`returns false for string with dupes: ${s}`, function() {
        expect(func(s)).to.be.false;
      });
    });

  });
}
