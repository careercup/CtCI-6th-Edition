require('../../test_helper');
describe('3.5 #MyQueue', function () {
  describe('pop', function () {

    it('returns undefined in 0 length queue', function () {
      var q = new MyQueue();
      var item = q.pop();
      expect(item).to.be.undefined;
    });

    it('returns 1st item in 1 length queue', function () {
      var q = new MyQueue();
      q.push('foo');
      var item = q.pop();
      expect(item).to.be.equal('foo');
    });

    it('returns 2nd then 1st item in 2 length queue', function () {
      var q = new MyQueue();
      q.push('foo');
      q.push('bar');
      var item = q.pop();
      expect(item).to.be.equal('foo');
      item = q.pop();
      expect(item).to.be.equal('bar');
    });
  });
});
