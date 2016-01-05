import unittest
#O(N)
def OneAway(str1,str2):
    if str1==str2:
        return True
    if len(str1) == len(str2)+1:
        return tryremove(str1, str2)
    if len(str2) == len(str1)+1:
        return tryremove(str2, str1)
    if len(str1) == len(str2):
        return tryreplace(str1, str2)
    else:
        return False

def tryremove(teststring, comparestring): 
    for i in range(len(teststring)):
        test=list(teststring)
        test.pop(i)
        if "".join(test)==comparestring:
            return True
    return False

def tryreplace(teststring, comparestring): 
    count=0
    for i in range(len(teststring)):
        if teststring[i] != comparestring[i]:
            count+=1
        if count > 1:
            return False
    return True

class Test(unittest.TestCase):
    '''Test Cases'''
    data = [
        ("pale", "ple", True),
        ("pales", "pale", True),
        ("pale", "bale", True),
        ("bale", "bale", True),
        ("pale", "palid", False),
        ("pale", "bake", False)]

    def test_one_away(self):
        for [test_string1, test_string2, expected] in self.data:
            actual = OneAway(test_string1, test_string2)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()

