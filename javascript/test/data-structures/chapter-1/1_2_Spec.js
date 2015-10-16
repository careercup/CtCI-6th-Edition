require('../../test_helper');
describe('1.2 #isPermutation', function () {
  var str1, str2;
  beforeEach(function () {
    str1 = 'hello';
    str2 = 'olleh';
    str3 = 'abcdef';
  });
  it('returns true if strings are permutations', function () {
    expect(Strings1_2.isPermutation(str1, str2)).to.be.true;
  });
  it('returns false if strings are not permutations', function () {
    expect(Strings1_2.isPermutation(str1, str3)).to.be.false;
  });
});
