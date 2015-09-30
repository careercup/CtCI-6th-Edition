require('../../test_helper');
describe('1.1 #hasUniqueChars', function () {
  var str1, str2;
  beforeEach(function () {
    str1 = 'abcdef';
    str2 = 'qwertyuiopasdfghjkl;\'zxcvbnm,.';
    str3 = 'abcdefa';
  });
  it('returns true if string is all unique chars', function () {
    expect(Strings_1_1.isUnique(str1)).to.be.true;
  });
  it('returns true if string is all unique chars', function () {
    expect(Strings_1_1.isUnique(str2)).to.be.true;
  });
  it('returns false if string contains duplicate chars', function () {
    expect(Strings_1_1.isUnique(str3)).to.be.false;
  });
});
