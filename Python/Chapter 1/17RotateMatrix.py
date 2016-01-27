import unittest
#O(N*N)
def RotateMatrix(nbynarray):
    length = len(nbynarray)
    nlayers = length/2
    for layer in range(nlayers):
        length = len(nbynarray)
        first = layer
        last = length-1-layer
        for i in range(first,last):
            offset=i-first
            tmp=nbynarray[first][i]#top
            nbynarray[first][i] = nbynarray[last-offset][first]
            nbynarray[last-offset][first] = nbynarray[last][last-offset]
            nbynarray[last][last-offset] = nbynarray[i][last]
            nbynarray[i][last] = tmp
    return nbynarray

class Test(unittest.TestCase):
    '''Test Cases'''
    data = [
        ([[1,2],[3,4]], [[3,1],[4,2]]),
        ([[1,2,3],[4,5,6],[7,8,9]], [[7,4,1],[8,5,2],[9,6,3]]),
        ([[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]],[[13,9,5,1],[14,10,6,2],[15,11,7,3],[16,12,8,4]])]

    def test_rotate_mat(self):
        for [array, expected] in self.data:
            actual = RotateMatrix(array)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()

