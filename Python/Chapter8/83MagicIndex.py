def MagicIndex(array, min, max):
    mid = (max + min)/2
    if array[mid] == mid:
        return mid
    if array[mid] < mid:
        return MagicIndex(array, mid + 1, max)
    if array[mid] > mid:
        return MagicIndex(array, min, mid - 1)

def FillArray():
    array = [0]*10
    array[0] = -14
    array[1] = -12
    array[2] = 0
    array[3] = 1
    array[4] = 2
    array[5] = 5
    array[6] = 9
    array[7] = 10
    array[8] = 23
    array[9] = 25
    return array
    
array = FillArray()
print MagicIndex(array, 0, len(array) - 1)
