import unittest
#O(N)
def PalindromePermutation(string):
    letters=[0]*128
    string=string.lower()
    for i in range(len(string)):
        letters[ord(string[i])] += 1
    count=0
    for i in range(len(letters)):
        if letters[i]%2 == 1 and i!=ord(" "):
            count += 1
    if count > 1:
        return False
    return True

class Test(unittest.TestCase):
    '''Test Cases'''
    data = [
        ("Tact coa", True),
        ("lloab", False),
        ("llo", True)]

    def test_pal_perm(self):
        for [test_string, expected] in self.data:
            actual = PalindromePermutation(test_string)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()
