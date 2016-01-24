import Queue

class Graph():
    def __init__(self):
        self.max_vertices = 6
        self.vertices = [0]*self.max_vertices
        self.count = 0
    
    def addNode(self, x):
        if self.count < self.max_vertices:
            self.vertices[self.count] = x
            self.count += 1
        else:
            print "Graph full"
    
    def getNodes(self):
        return self.vertices

class Node():
    def __init__(self, vertex, adjacentLength):
        self.adjacent = [0]*adjacentLength
        self.vertex = vertex
        self.adjacentCount = 0
        self.visited = False

    def addAdjacent(self, x):
        if self.adjacentCount < len(self.adjacent):
            self.adjacent[self.adjacentCount] = x
            self.adjacentCount += 1
        else:
            print "No more adjacent nodes can be added"

    def getAdjacent(self):
        return self.adjacent

    def getVertex(self):
        return self.vertex

def depthfirstsearch(g, start, end):
    if start == end:
        return True
    q = Queue.Queue(len(g.getNodes()))
    start.visited = True
    q.put(start)
    while not q.empty():
        r = q.get()
        if r != None:
            adjacent = r.getAdjacent()
            for i in range(len(adjacent)):
                if adjacent[i].visited == False:
                    if adjacent[i] == end:
                        return True
                    else:
                        q.put(adjacent[i])
                    adjacent[i].visited = True
    return False

def createNewGraph():
    g = Graph()
    sizegraph = 6
    temp = [0]*sizegraph

    temp[0] = Node("a", 3)
    temp[1] = Node("b", 0)
    temp[2] = Node("c", 0)
    temp[3] = Node("d", 1)
    temp[4] = Node("e", 1)
    temp[5] = Node("f", 0)

    temp[0].addAdjacent(temp[1])
    temp[0].addAdjacent(temp[2])
    temp[0].addAdjacent(temp[3])
    temp[3].addAdjacent(temp[4])
    temp[4].addAdjacent(temp[5])

    for i in range(sizegraph):
        g.addNode(temp[i])
    return g

def createNewGraphWithLoop():
    g = Graph()
    sizegraph = 6
    temp = [0]*sizegraph

    temp[0] = Node("a", 1)
    temp[1] = Node("b", 1)
    temp[2] = Node("c", 1)
    temp[3] = Node("d", 1)
    temp[4] = Node("e", 2)
    temp[5] = Node("f", 0)

    temp[0].addAdjacent(temp[1])
    temp[1].addAdjacent(temp[2])
    temp[2].addAdjacent(temp[3])
    temp[3].addAdjacent(temp[4])
    temp[4].addAdjacent(temp[1])
    temp[4].addAdjacent(temp[5])
    
    for i in range(sizegraph):
        g.addNode(temp[i])
    return g

g = createNewGraphWithLoop()
n = g.getNodes()
start = n[0]
end = n[5]
print "Start at:", start.getVertex(), "End at: ", end.getVertex()
print depthfirstsearch(g, start, end)
