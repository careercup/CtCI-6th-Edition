module.exports = MyQueue = (function(){

  function MyQueue() {
    if (!(this instanceof MyQueue)) {
      return new MyQueue;
    }
    this.oldStack = [];
    this.newStack = [];
  };

  function shiftStacks() {
    if(this.oldStack.length == 0) {
      while(this.newStack.length > 0) {
        this.oldStack.push(this.newStack.pop());
      }
    }
  };

  MyQueue.prototype.push = function(item) {
    this.newStack.push(item);
  };

  MyQueue.prototype.pop = function() {
    shiftStacks.call(this);
    return this.oldStack.pop();
  };

  return MyQueue;
})();
