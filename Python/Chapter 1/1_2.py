# permutation check
# O(NlogN)
import unittest

def checkPermutation(string):
  str1, str2 = string[0], string[1]
  if (len(str1) == len(str2)):
    arr1, arr2 = [], []
    for char in str1:
      arr1.append(char)
    for char in str2:
      arr2.append(char)
    arr1.sort()
    arr2.sort()
    for x in range(len(arr1)):
      if arr1[x] != arr2[x]:
        return False
    return True
  else:
    return False

class Test(unittest.TestCase):
  dataT = [(['abcd', 'bacd'], True), (['3563476', '7334566'], True), (['wef34fwe', 'wwffee34'], True)]
  dataF = [(['abcd', 'd2cba'], False), (['2354', '1234'], False), (['dcw4f', 'dcw5f'], False)]

  def test_checkPermutation(self):
    for test_string in self.dataT:
      actual = checkPermutation(test_string[0])
      self.assertTrue(actual)

    for test_string in self.dataF:
      actual = checkPermutation(test_string[0])
      self.assertFalse(actual)

if __name__ == "__main__":
  unittest.main()
