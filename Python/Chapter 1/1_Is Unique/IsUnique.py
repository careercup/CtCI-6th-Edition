# O(N)
import unittest

def unique(string):
    # function to check if all characters in string are unique
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
    dataT = [('abcd'), ('s4fad'), ('')]
    dataF = [('23ds2'), ('hb 627jh=j ()')]

    def test_unique(self):
        # true check
        for test_string in self.dataT:
            actual = unique(test_string)
            self.assertTrue(actual)
        # false check
        for test_string in self.dataF:
            actual = unique(test_string)
            self.assertFalse(actual)

if __name__ == "__main__":
    unittest.main()
