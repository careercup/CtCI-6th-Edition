require('../../test_helper');
describe('1.9 #isRotation', function () {
  var str1, str2;
  beforeEach(function () {
    str1 = 'waterbottle';
    str2 = 'erbottlewat';
  });
  it('returns false if strings are not same length', function () {
    expect(Strings_1_8.isRotation('hello', '')).to.be.false;
  });
  it('returns false if str1 is blank', function () {
    expect(Strings_1_8.isRotation('', '')).to.be.false;
  });
  it('returns true if str2 is rotation of str1', function () {
    expect(Strings_1_8.isRotation(str1, str2)).to.be.true;
  });
});
