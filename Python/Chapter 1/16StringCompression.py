import unittest
#O(N)
def StringCompression(str1):
    str1 = str1.lower()
    out = ""
    count = 0
    oldletter = str1[0]
    compressible = False
    for i in range(0,len(str1)):
        if str1[i] != oldletter and i > 0:
            out = out + oldletter + str(count)
            oldletter = str1[i]
            count = 1
        else:
            count += 1
        if count > 1:
            compressible = True
    out = out + oldletter + str(count)
    if compressible == True:
        return out
    else:
        return str1

class Test(unittest.TestCase):
    '''Test Cases'''
    data = [
        ("abcd", "abcd"),
        ("agggiigggii", "a1g3i2g3i2"),
        ("aabcccccaaa", "a2b1c5a3")]

    def test_string_compression(self):
        for [test_string1, expected] in self.data:
            actual = StringCompression(test_string1)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()

