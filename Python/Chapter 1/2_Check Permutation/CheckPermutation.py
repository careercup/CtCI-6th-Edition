# permutation check
# O(NlogN)
import unittest

def check_permutation(string):
    str1, str2 = string[0], string[1]
    if len(str1) == len(str2):
        arr1, arr2 = [], []
        for char in str1:
            arr1.append(char)
        for char in str2:
            arr2.append(char)
        arr1.sort()
        arr2.sort()
        for index in range(len(arr1)):
            if arr1[index] != arr2[index]:
                return False
        return True
    else:
        return False

class Test(unittest.TestCase):
    dataT = [(['abcd', 'bacd'], True), (['3563476', '7334566'], True), (['wef34f', 'wffe34'], True)]
    dataF = [(['abcd', 'd2cba'], False), (['2354', '1234'], False), (['dcw4f', 'dcw5f'], False)]

    def test_cp(self):
        for test_string in self.dataT:
            actual = check_permutation(test_string[0])
            self.assertTrue(actual)

        for test_string in self.dataF:
            actual = check_permutation(test_string[0])
            self.assertFalse(actual)

if __name__ == "__main__":
    unittest.main()
