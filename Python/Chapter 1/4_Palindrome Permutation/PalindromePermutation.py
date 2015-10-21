# O(N)
import unittest

def pal_perm(string):
    '''function checks if a string is a permutation of a palindrome or not'''
    array = []
    for char in string:
        if char != ' ':
            array.append(char.lower())
    # even number of elements
    if len(array)%2 == 0:
        for index in range(len(array)):
            if char_count(array[index], array)%2 != 0:
                return False

    # odd number of elements
    elif len(array)%2 != 0:
        mid_alph_occur_count = 0
        for index in range(len(array)):
            if char_count(array[index], array)%2 != 0:
                mid_alph_occur_count += 1
        if mid_alph_occur_count == 1:
            return True
        else:
            return False

def char_count(char, array):
    '''Counts the number of times an alphabet occurs in the string'''
    count = 0
    for chars in array:
        if char == chars:
            count += 1
    return count


class Test(unittest.TestCase):
    '''Test Cases'''
    data = [
        ('Tact Coa', True),
        ('jhsabckuj ahjsbckj', True),
        ('Able was I ere I saw Elba', True),
        ('So patient a nurse to nurse a patient so', False),
        ('Random Words', False),
        ('Not a Palindrome', False)]

    def test_pal_perm(self):
        for [test_string, expected] in self.data:
            actual = pal_perm(test_string)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()
