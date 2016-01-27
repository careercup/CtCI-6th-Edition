class node:
    def __init__(self):
        self.data = None # contains the data
        self.next = None # contains the reference to the next node

class linked_list:
    def __init__(self):
        self.head = None
        self.last_element = None

    def add_node(self, data):
        new_node = node() # create a new node
        new_node.data = data
        new_node.next = self.head # link the new node to the 'previous' one
        self.head = new_node #  set the current node to the new one.
        if not self.last_element:
            self.last_element = self.head
        
    def list_print(self):
        node = self.head 
        while node:
            print node.data
            node = node.next

    def partition_list(self, partitionvalue):
        less = linked_list()
        more = linked_list()
        node = self.head
        while node:
            if node.data < partitionvalue:
                less.add_node(node.data)
            else:
                more.add_node(node.data)
            node = node.next
        less.last_element.next  = more.head
        return less
        
def fill_list():
    ll = linked_list()
    ll.add_node(1)
    ll.add_node(2)
    ll.add_node(3)
    ll.add_node(7)
    ll.add_node(4)
    ll.add_node(2)
    ll.add_node(2)
    ll.add_node(7)
    ll.add_node(7)
    ll.add_node(9)
    ll.add_node(3)
    ll.add_node(3)
    return ll

def Partition(partitionvalue):
    ll=fill_list()
    print "Initial List"
    ll.list_print()
    ll = ll.partition_list(partitionvalue)
    print "Final List"   
    ll.list_print()

partitionvalue = 4#node number to partition around
Partition(partitionvalue)

