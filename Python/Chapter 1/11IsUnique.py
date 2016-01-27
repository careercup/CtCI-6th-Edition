import unittest
#O(N)
def IsUnique(string):
    if len(string) > 128:#max size ascii alphabet
        return False
    strcounter=0
    for i in range(len(string)):
        val = ord(string[i])
        if (strcounter & (1 << val)) > 0:
            return False
        strcounter |= (1 << val)
    return True

class Test(unittest.TestCase):
    '''Test Cases'''
    data = [
        ("hello", False),
        ("hide", True),
        ("hi\d(e", True),
        ("h\i\de", False)]

    def test_is_unique(self):
        for [test_string, expected] in self.data:
            actual = IsUnique(test_string)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()

