# O(N)
import unittest

def unique(string):
    count = 0
    hash_table = {}
    for character in string:
        count += 1
        if character not in hash_table.values():
            hash_table[count] = character
    if len(hash_table) == count:
        return True
    else:
        return False

class Test(unittest.TestCase):
    dataT = [('abcd', True), ('s4fad', True), ('', True)]
    dataF = [('23ds2', False), ('hb 627jh=j ()', False)]

    def test_unique(self):
        for test_string in self.dataT:
            actual = unique(test_string[0])
            self.assertTrue(actual)

        for test_string in self.dataF:
            actual = unique(test_string[0])
            self.assertFalse(actual)

if __name__ == "__main__":
    unittest.main()
