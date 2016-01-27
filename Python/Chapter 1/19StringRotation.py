import unittest
#O(N)
def StringRotation(original, rotated):
    if len(original) != len(rotated):
        return False
    test = rotated + rotated
    if isSubstring(original, test):
        return True
    else:
        return False

def isSubstring(substr,fullstr):
    if fullstr.find(substr) == -1:
        return False
    return True

class Test(unittest.TestCase):
    '''Test Cases'''
    data = [ 
        ("waterbottle","erbottlewat", True),
        ("waterbottles","erbottlewats", False),
        ("waterbottlelong","erbottlewat", False)]


    def test_string_rot(self):
        for [str1, str2, expected] in self.data:
            actual = StringRotation(str1, str2)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()

