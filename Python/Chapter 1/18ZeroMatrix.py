import unittest
#O(N*N)
def ZeroMatrix(matrix):
    m = len(matrix)
    n = len(matrix[0])
    rowtracker = [False]*m
    columntracker = [False]*n
    for i in range(m):
        for j in range(n):        
            if matrix[i][j] == 0:
                rowtracker[i] = True
                columntracker[j] = True
    for row in range(m):
        if rowtracker[row]:
            eliminaterow(matrix, row)
    for col in range(n):
        if columntracker[col]:
            eliminatecol(matrix, col)
    return matrix

def eliminaterow(matrix, row):
    for col in range(len(matrix[0])):
        matrix[row][col] = 0
    return matrix

def eliminatecol(matrix, col):
    for row in range(len(matrix)):
        matrix[row][col] = 0
    return matrix

            
class Test(unittest.TestCase):
    '''Test Cases'''
    data = [ 
        ([[1,2],[0,4]], [[0,2],[0,0]]),
        ([[1,2,3],[4,0,6],[7,8,9]], [[1,0,3],[0,0,0],[7,0,9]]),
        ([[0,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]],[[0,0,0,0],[0,6,7,8],[0,10,11,12],[0,14,15,16]])]

    def test_zeromat(self):
        for [array, expected] in self.data:
            actual = ZeroMatrix(array)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()

