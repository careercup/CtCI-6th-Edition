import unittest
#O(N)
def CheckPermutation(str1, str2):
    if len(str1) != len(str2):
        return False
    strcount=[0]*128
    for i in range(len(str1)):
        strcount[ord(str1[i])] += 1
    for i in range(len(str2)):
        strcount[ord(str2[i])] -= 1
    for i in range(0,128):
        if strcount[i] != 0:
            return False
    return True

class Test(unittest.TestCase):
    '''Test Cases'''
    data = [
        ("Hello", "elloH", True),
        ("Hello", "wells", False)]

    def test_check_perm(self):
        for [test_str1, test_str2, expected] in self.data:
            actual = CheckPermutation(test_str1, test_str2)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()

