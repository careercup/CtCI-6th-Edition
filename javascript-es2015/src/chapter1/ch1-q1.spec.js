import { expect } from 'chai';
import * as funcs from './ch1-q1';

for (let key in funcs) {
  let func = funcs[key];
  describe('ch1-q1: ' + key, function() {

    [
      'abcdefghi',
      'jklpoiuqwerzxcvmnsadf',
      '1234567890',
      'AaBbCcDdeFg1234567890(*&^%$#@!)'
    ].forEach(str => {

      it(`returns true for unique string: '${str}'`, function() {
        expect(func(str.split(''))).to.be.true;
      });

    });

    [
      'abcadef',
      'aaaaaaaaaa',
      'abcdefghijklmnopqrstuvwxyza',
      '1234567890asdklf1',
      '!@#$%^&*()(*#($&#(*$&#*($&#()))))'
    ].forEach(str => {

      it(`returns false for string with dupes: '${str}'`, function() {
        expect(func(str.split(''))).to.be.false;
      });

    });

  });
}
