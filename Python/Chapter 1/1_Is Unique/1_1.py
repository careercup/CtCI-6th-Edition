# O(N)
import unittest

def unique(string):
  count = 0
  hash_table = {}
  for character in string:
    count += 1
    if character not in hash_table.values():
      hash_table[count] = character
  if(len(hash_table) == count):
    return True
  else:
    return False

class Test(unittest.TestCase):
  data = [('abcd', True), ('23fdsf2', False), ('swe1234fad', True), ('hb 627 jh =j ()', False), ('', True)]

  def test_unique(self):
    for test_string in self.data:
      actual = unique(test_string)
      self.assertTrue(actual)

if __name__ == "__main__":
  unittest.main()
