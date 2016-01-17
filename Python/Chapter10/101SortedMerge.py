def SortedMerge(A, B):
    index = len(A) - 1
    indexB = len(B) - 1
    indexA = len(A) -len(B) - 1
    
    while indexB >= 0:
        if indexA > 0 and A[indexA] > B[indexB]:
            A[index] = A[indexA]
            indexA -= 1
        else:
            A[index] = B[indexB]
            indexB -= 1
        index -= 1
    return A

def FillArrayUpTo(maxnum):
    nums = [0]*maxnum
    for i in range(len(nums)):
        nums[i] = 2*i + 4
    return nums

def FillArrayWithBuffer(length,buffer):
    nums = [0]*(length + buffer)
    for i in range(length):
        nums[i] = 3*i + 1
    return nums

A = FillArrayWithBuffer(5, 10)
B = FillArrayUpTo(10)
print A, B
print SortedMerge(A, B)

