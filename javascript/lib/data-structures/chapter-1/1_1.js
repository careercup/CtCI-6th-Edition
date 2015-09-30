module.exports = Strings_1_1 = (function() {
  return {
    /*
     * Tests to see if string contains all unique chars.
     * @param {String} str - The string to be checked for uniqueness
     * @returns {Boolean} true if string has only unique chars. False if a duplicate exists
     */
    isUnique: function(str) {
      var char_set = Array.apply(null, Array(256)).map(Boolean.prototype.valueOf, false);
      for (var i = 0; i < str.length; i++) {
        if (char_set[str[i].charCodeAt(0)]) {
          return false;
        }
        char_set[str[i].charCodeAt(0)] = true;
      }
      return true;
   }
  };
}());
