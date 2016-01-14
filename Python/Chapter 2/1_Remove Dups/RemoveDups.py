#O(N^2)
class Node(object):
    def __init__(self, data, next):
        self.data = data
        self.next = next

class SinglyLinkedList(object):
    head = None
    tail = None

    def printList(self):
        current = self.head
        while current is not None:
            print current.data, '->',
            current = current.next
        print None

    def insert(self, data):
        node = Node(data, None)
        if self.head is None:
            self.head = self.tail = node
        else:
            self.tail.next = self.tail = node

    def deleteDups(self):
        current = self.head
        while current is not None:
            runner = current
            while runner.next is not None:
                if runner.next.data == current.data:
                    runner.next = runner.next.next
                else:
                    runner = runner.next
            current = current.next

s = SinglyLinkedList()
s.insert(31)
s.insert(98)
s.insert(31)
s.insert(98)
s.insert(3)
s.insert(8)
s.printList()
s.deleteDups()
s.printList()
