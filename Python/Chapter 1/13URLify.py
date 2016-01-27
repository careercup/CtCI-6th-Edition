import unittest
#O(N)
def URLify(string, length):
    count=len(string)-1
    out=list(string)
    for i in range(length-1,-1,-1):
        if out[i]==" ":
            out[count] = "0"
            out[count-1] = "2"
            out[count-2] = "%"
            count-=3
        else:
            out[count] = string[i]
            count-=1
    return "".join(out)

class Test(unittest.TestCase):
    '''Test Cases'''
    data = [
        ("Mr John Smith    ", 13, "Mr%20John%20Smith")]

    def test_urlify(self):
        for [test_string, length, expected] in self.data:
            actual = URLify(test_string, length)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()

