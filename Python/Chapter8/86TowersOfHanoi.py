import sys

class MultiStack:
    def __init__(self, stacksize):
        self.numstacks = 3
        self.array = [0]*(stacksize*self.numstacks)
        self.sizes = [0]*self.numstacks
        self.stacksize = stacksize
        self.minvals = [sys.maxint]*(stacksize*self.numstacks)

    def Push(self, item, stacknum):
        if self.IsFull(stacknum):
            raise Exception('Stack is full')
        self.sizes[stacknum] += 1         
        if self.IsEmpty(stacknum):
            self.minvals[self.IndexOfTop(stacknum)] = item    
        else:
            self.minvals[self.IndexOfTop(stacknum)] = min(item, self.minvals[self.IndexOfTop(stacknum)-1])  
        self.array[self.IndexOfTop(stacknum)] = item

    def Pop(self, stacknum):
        if self.IsEmpty(stacknum):
            raise Exception('Stack is empty')
        value = self.array[self.IndexOfTop(stacknum)]
        self.array[self.IndexOfTop(stacknum)] = 0
        self.sizes[stacknum] -= 1
        return value

    def Peek(self, stacknum):
        if self.IsEmpty(stacknum):
            raise Exception('Stack is empty')
        return self.array[self.IndexOfTop(stacknum)]
    
    def Min(self, stacknum):
        return self.minvals[self.IndexOfTop(stacknum)]
        
    def IsEmpty(self, stacknum):
        return self.sizes[stacknum] == 0
    
    def IsFull(self, stacknum):
        return self.sizes[stacknum] == self.stacksize
              
    def IndexOfTop(self, stacknum):
        offset = stacknum*self.stacksize
        return offset + self.sizes[stacknum] - 1 

    def Size(self, stacknum):
        return self.sizes[stacknum]
    
def f(N, start, end, buff, stack):
    if N == 1:
        stack.Push(stack.Pop(start), end)
    else:
        f(N-1, start, buff, end, stack)
        f(1, start, end, buff, stack)
        f(N-1, buff, end, start, stack) 

def printTower(newstack):
    #while not newstack.IsEmpty(0):
        #print newstack.Pop(0)
        #print "".join("-" for i in range(newstack.Pop(0)))
    #while not newstack.IsEmpty(1):
        #print newstack.Pop(1)
        #print "".join("-" for i in range(newstack.Pop(1)))
    while not newstack.IsEmpty(2):
        #print newstack.Pop(2)
        print "".join("-" for i in range(newstack.Pop(2)))
    
def FillTower(N):
    newstack = MultiStack(N*3)
    for i in range(N, 0, -1):
        newstack.Push(i, 0)
    return newstack

N = 3
newstack = FillTower(N)
f(N, 0, 2, 1, newstack)    
printTower(newstack)

